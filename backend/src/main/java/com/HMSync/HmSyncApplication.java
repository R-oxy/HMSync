package com.HMSync;

import com.HMSync.configuration.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class HmSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmSyncApplication.class, args);
	}

}
