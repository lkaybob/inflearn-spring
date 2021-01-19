package me.lkaybob.externalconfigurationexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties") // 이걸 지우면 어떻게 될까?
class ExternalConfigurationExampleApplicationTests {
    @Autowired
    Environment environment;

    @Test
    void contextLoads() {
        assertThat(environment.getProperty("kaybob.name"))
                .isEqualTo("Larry");
    }

}
