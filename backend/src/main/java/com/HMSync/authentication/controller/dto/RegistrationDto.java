package com.HMSync.authentication.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class RegistrationDto {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String gender;
    private Date dateOfBirth;
    private IdentificationDocumentDto identificationDocumentDto;
    private String identificationNumber;
    private String nextOfKin;
    private String nextOfKinMobile;
}
