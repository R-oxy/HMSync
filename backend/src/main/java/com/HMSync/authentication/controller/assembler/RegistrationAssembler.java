package com.HMSync.authentication.controller.assembler;

import com.HMSync.authentication.controller.dto.IdentificationDocumentDto;
import com.HMSync.authentication.controller.dto.RegisterRequestDto;
import com.HMSync.authentication.controller.dto.RegistrationDto;
import com.HMSync.authentication.repository.IdentificationDocumentRepository;
import com.HMSync.security.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegistrationAssembler {
    private final IdentificationDocumentAssembler identificationDocumentAssembler;
    private final IdentificationDocumentRepository identificationDocumentRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationDto toRegistrationDto(User from) {
        RegistrationDto to = new RegistrationDto()
                .setUserId(from.getUserId())
                .setFirstName(from.getFirstName())
                .setLastName(from.getLastName())
                .setEmail(from.getEmail())
                .setPhoneNumber(from.getPhoneNumber())
                .setGender(from.getGender())
                .setDateOfBirth(from.getDateOfBirth())
                .setIdentificationDocumentDto(identificationDocumentAssembler.toIdentificationDocumentDto(from.getIdentificationDocument()))
                .setIdentificationNumber(from.getIdentificationNumber())
                .setNextOfKin(from.getNextOfKin())
                .setNextOfKinMobile(from.getNextOfKinMobile());

        return to;
    }

    public User toUser(RegisterRequestDto from, User to) {
        to.setFirstName(from.getFirstName())
                .setLastName(from.getLastName())
                .setEmail(from.getEmail())
                .setPhoneNumber(from.getPhoneNumber())
                .setGender(from.getGender())
                .setDateOfBirth(from.getDateOfBirth())
                .setIdentificationNumber(from.getIdentificationNumber())
                .setNextOfKin(from.getNextOfKin())
                .setNextOfKinMobile(from.getNextOfKinMobile())
                .setPassword(passwordEncoder.encode(from.getPassword()))
                .setRole(from.getRole());

        identificationDocumentRepository.findByName(IdentificationDocumentDto.IDENTIFICATION_CARD.getValue())
                .ifPresent(to::setIdentificationDocument);

        return to;
    }

}
