package com.HMSync.notification.service;

import com.HMSync.notification.controller.dto.EmailRequestDto;

public interface EmailService {
    void sendEmail(EmailRequestDto emailRequestDto);
}
