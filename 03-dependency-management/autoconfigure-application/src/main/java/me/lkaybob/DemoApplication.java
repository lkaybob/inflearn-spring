package me.lkaybob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DemoApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

//    과연 이걸 다 정의해야할까? (properties 를 정의해서 할 수 있음!)
//    @Bean
//    public Holoman holoman() {
//        Holoman holoman = new Holoman();
//        holoman.setName("Kaybob");
//        holoman.setHowLong(50);
//        return holoman;
//    }

}
