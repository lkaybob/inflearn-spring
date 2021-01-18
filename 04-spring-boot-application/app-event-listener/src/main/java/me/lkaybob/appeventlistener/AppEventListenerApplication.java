package me.lkaybob.appeventlistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppEventListenerApplication {

    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(AppEventListenerApplication.class);
//        springApplication.addListeners(new SampleListener());
//        springApplication.run(args);

        SpringApplication.run(AppEventListenerApplication.class, args);
    }

}
