package me.lkaybob.externalconfigurationexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@TestPropertySource(locations = "classpath:test.properties")
@TestPropertySource // resources 폴더의 properties 파일을 찾게 됨 (클래스 이름.properties)
// @TestPropertySource 어노테이션이 없으면 application.properties을 따른다고 보면 됨 (물론 우선순위를 따름)
class ExternalConfigurationExampleApplicationTests {
    @Autowired
    Environment environment;

    @Test
    void contextLoads() {
        assertThat(environment.getProperty("kaybob.name"))
                .isEqualTo("Larry");
    }

}
