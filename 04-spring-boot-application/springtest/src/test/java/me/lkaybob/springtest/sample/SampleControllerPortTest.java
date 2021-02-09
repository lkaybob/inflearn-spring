package me.lkaybob.springtest.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class SampleControllerMockTest {
    // WebEnvironment.MOCK을 사용해야할 때
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    public void helloTest() throws Exception {
//        mockMvc.perform(get("/hello"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("hello kaybob"))
//                .andDo(print());
//    }

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

    // Webflux를 사용해서 테스트 할 때
//    @Autowired
//    WebTestClient webTestClient;
//
//    @MockBean
//    SampleService mockSampleService;
//
//    @Test
//    public void helloWebTestClient() {
//        when(mockSampleService.getName()).thenReturn("larry");
//
//        webTestClient.get().uri("/hello").exchange().expectStatus().isOk().expectBody(String.class).isEqualTo("hello larry");
//    }
}