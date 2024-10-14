package com.HMSync.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app")
@Component
@Data
public class ApplicationProperties {
    private SmtpProperties smtp = new SmtpProperties();

    @Data
    public static class SmtpProperties {
        private String host;
        private int port;
        private String username;
        private String password;
        private boolean auth;
        private boolean starttlsEnable;
        private boolean starttlsRequired;
        private int connectionTimeout;
        private int timeout;
        private int writeTimeout;
        private boolean debug;
    }
}
