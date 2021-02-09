package me.lkaybob.springtest.sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerWebfluxTest {
    // Webflux를 쓸 때는 이렇게
    // mockWebTestClient에서 빨간줄 그어지는건... 이유 모르겠음...
    @Autowired
    WebTestClient mockWebTestClient;

    @MockBean
    SampleService mockSampleService;

    @Test
    public void helloWebTestClient() {
        when(mockSampleService.getName()).thenReturn("larry");

        mockWebTestClient.get().uri("/hello").exchange().expectStatus().isOk().expectBody(String.class).isEqualTo("hello larry");
    }
}
