package com.HMSync.authentication.service;

import com.HMSync.authentication.controller.assembler.RegistrationAssembler;
import com.HMSync.authentication.controller.dto.AuthenticationDto;
import com.HMSync.authentication.controller.dto.AuthenticationRequestDto;
import com.HMSync.authentication.controller.dto.RegisterRequestDto;
import com.HMSync.authentication.controller.dto.RegistrationDto;
import com.HMSync.notification.controller.dto.EmailRequestDto;
import com.HMSync.notification.service.EmailService;
import com.HMSync.security.jwt.entity.Token;
import com.HMSync.security.jwt.entity.TokenType;
import com.HMSync.security.jwt.repository.TokenRepository;
import com.HMSync.security.jwt.service.JwtService;
import com.HMSync.security.user.entity.User;
import com.HMSync.security.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RegistrationAssembler registrationAssembler;
    private final EmailService emailService;

    public RegistrationDto register(RegisterRequestDto request) {
        var user = registrationAssembler.toUser(request, new User());
        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        var registrationDto = registrationAssembler.toRegistrationDto(savedUser);
        sendRegistrationEmail(user);
        return registrationDto;
    }

    public AuthenticationDto authenticate(AuthenticationRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationDto.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getUserId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationDto.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

    private void sendRegistrationEmail(User user) {
        EmailRequestDto emailRequestDto = new EmailRequestDto();
        emailRequestDto.setTo(Collections.singletonList(user.getEmail()));
        emailRequestDto.setSubject("Welcome to HMSync");
        emailRequestDto.setBody("Dear " + user.getFirstName() + ",\n\n" +
                "Thank you for registering with HMSync.\n\n" +
                "Best regards,\nHMSync Team");

        emailService.sendEmail(emailRequestDto);
    }
}
