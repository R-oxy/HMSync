package com.HMSync.security.user.controller.dto;

import lombok.Data;

@Data
public class ChangePasswordRequestDto {
    private String currentPassword;
    private String newPassword;
    private String confirmationPassword;
}
