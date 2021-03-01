package me.lkaybob.neo4jdemo;

import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.internal.SessionFactory;
import org.neo4j.driver.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Neo4jRunner implements ApplicationRunner {
    // SessionFactory를 활용해서 사용하는 방법은 더이상 안 먹히는 듯함
    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        Role role = new Role();

        account.setUsername("kaybob");
        account.setEmail("a@bc.com");
        role.setRole("admin");
        account.getRoles().add(role);

        accountRepository.save(account);
    }
}
