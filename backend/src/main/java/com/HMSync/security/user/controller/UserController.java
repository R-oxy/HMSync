package com.HMSync.security.user.controller;

import com.HMSync.authentication.controller.assembler.RegistrationAssembler;
import com.HMSync.authentication.controller.dto.RegistrationDto;
import com.HMSync.security.user.controller.dto.ChangePasswordRequestDto;
import com.HMSync.security.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final RegistrationAssembler registrationAssembler;

    @PatchMapping
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequestDto request,
            Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<RegistrationDto> getAll(Pageable pageable) {
        return service.getAll(pageable)
                .map(registrationAssembler::toRegistrationDto);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public RegistrationDto get(@PathVariable UUID userId) {
        return registrationAssembler.toRegistrationDto(service.get(userId));
    }
}
