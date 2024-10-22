package com.HMSync.configuration;

import com.HMSync.security.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {
    private final UserRepository repository;
    private final ApplicationProperties applicationProperties;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return new SpringSecurityAuditorAware();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(applicationProperties.getSmtp().getHost());
        mailSender.setPort(applicationProperties.getSmtp().getPort());
        mailSender.setUsername(applicationProperties.getSmtp().getUsername());
        mailSender.setPassword(applicationProperties.getSmtp().getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", String.valueOf(applicationProperties.getSmtp().isAuth()));
        props.put("mail.smtp.starttls.enable", String.valueOf(applicationProperties.getSmtp().isStarttlsEnable()));
        props.put("mail.smtp.starttls.required", String.valueOf(applicationProperties.getSmtp().isStarttlsRequired()));
        props.put("mail.smtp.connectiontimeout", applicationProperties.getSmtp().getConnectionTimeout());
        props.put("mail.smtp.timeout", applicationProperties.getSmtp().getTimeout());
        props.put("mail.smtp.writetimeout", applicationProperties.getSmtp().getWriteTimeout());
        props.put("mail.debug", String.valueOf(applicationProperties.getSmtp().isDebug()));

        return mailSender;
    }
}
