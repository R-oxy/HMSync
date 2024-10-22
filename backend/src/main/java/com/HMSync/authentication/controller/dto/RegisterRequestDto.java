package com.HMSync.authentication.controller.dto;

import com.HMSync.security.user.entity.Role;
import jakarta.validation.constraints.Email;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Data
public class RegisterRequestDto {

    @NotBlank(message = "First name is required")
    @Size(max = 100)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 100)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Size(max = 20)
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(max = 20)
    private String phoneNumber;

    @Size(max = 10)
    private String gender;

    private Date dateOfBirth;

    @NotBlank(message = "Identification number is required")
    @Size(max = 50)
    private String identificationNumber;

    @NotBlank(message = "Password is required")
    @Size(max = 100)
    private String password;

    @Size(max = 200)
    private String nextOfKin;

    @Size(max = 20)
    private String nextOfKinMobile;

    @NotNull(message = "Role is required")
    private Role role;
}
