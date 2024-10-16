package com.HMSync;

import com.HMSync.configuration.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
public class HmSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmSyncApplication.class, args);
	}

}
