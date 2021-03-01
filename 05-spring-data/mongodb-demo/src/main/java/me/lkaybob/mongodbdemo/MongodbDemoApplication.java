package me.lkaybob.mongodbdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongodbDemoApplication {

    @Autowired
    // MongoTemplate mongoTemplate;
    AccountRepository accountRepository;


    public static void main(String[] args) {
        SpringApplication.run(MongodbDemoApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                Account account = new Account();
                account.setEmail("a@bc.com");
                account.setUsername("larry");

                // mongoTemplate.insert(account);
                accountRepository.save(account);
            }
        };
    }
}
