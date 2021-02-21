package me.lkaybob.springcorssample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCorsSampleApplication {

    @GetMapping("/hello")
    // @CrossOrigin(origins = "http://localhost:18080")
    public String hello() {
        return "hello";
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringCorsSampleApplication.class, args);
    }

}
