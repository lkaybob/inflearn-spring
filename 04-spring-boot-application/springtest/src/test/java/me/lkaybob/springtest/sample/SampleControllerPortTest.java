package me.lkaybob.springtest.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerPortTest {
    // WebEnvironment.RANDOM_PORT
    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean // testRestTemplate 안에서 만들어지는 SampleService에 대한 Bean을 mocking해서 교체할 수 있음
    SampleService mockSampleService;

    @Test
    public void helloTestRestTemplate() {
        when(mockSampleService.getName()).thenReturn("larry");

        String result = testRestTemplate.getForObject("/hello", String.class);
        assertThat(result).isEqualTo("hello larry");
    }
}