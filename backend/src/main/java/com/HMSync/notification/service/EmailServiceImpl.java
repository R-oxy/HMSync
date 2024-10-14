package com.HMSync.notification.service;

import com.HMSync.notification.controller.dto.EmailRequestDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@AllArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender emailSender;
    private final Environment environment;

    private static final String NOREPLY_ADDRESS = "\"HMSync\" <aronmangati@gmail.com>";

    @Override
    public void sendEmail(EmailRequestDto emailRequestDto) {
        final boolean isDev = Arrays.stream(environment.getActiveProfiles())
                .anyMatch(profile -> profile.equalsIgnoreCase("dev")
                        || profile.equalsIgnoreCase("personal")
                        || profile.equalsIgnoreCase("local"));

        MimeMessage message = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_NO, StandardCharsets.UTF_8.name());

            String fromAddress = (emailRequestDto.getFrom() != null && !emailRequestDto.getFrom().isEmpty()) ?
                    emailRequestDto.getFrom() : NOREPLY_ADDRESS;
            helper.setFrom(fromAddress);

            helper.setTo(emailRequestDto.getTo().toArray(new String[0]));

            if (emailRequestDto.getCc() != null && !emailRequestDto.getCc().isEmpty()) {
                helper.setCc(emailRequestDto.getCc().toArray(new String[0]));
            }

            if (emailRequestDto.getBcc() != null && !emailRequestDto.getBcc().isEmpty()) {
                helper.setBcc(emailRequestDto.getBcc().toArray(new String[0]));
            }

            String subject = isDev ? "[DEV] " + emailRequestDto.getSubject() : emailRequestDto.getSubject();
            helper.setSubject(subject);

            helper.setText(emailRequestDto.getBody(), false);

            emailSender.send(message);
        } catch (MessagingException ex) {
            throw new RuntimeException("Error sending email", ex);
        }
    }
}
