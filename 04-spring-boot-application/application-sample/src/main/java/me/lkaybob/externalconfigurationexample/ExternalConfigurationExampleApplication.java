package me.lkaybob.externalconfigurationexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExternalConfigurationExampleApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ExternalConfigurationExampleApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run();
    }

}
