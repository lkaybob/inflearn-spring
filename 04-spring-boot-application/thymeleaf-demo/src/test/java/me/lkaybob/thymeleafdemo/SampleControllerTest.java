package me.lkaybob.thymeleafdemo;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SampleController.class)
class SampleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebClient webClient;

    @Test
    public void helloTest() throws Exception {
        // 요청 "/"
        // 응답
        // - 모델 name: larry
        // - 뷰 이름: hello
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("name", is("larry")))
                .andExpect(content().string(containsString("larry")));

        // 실제 렌더링 결과를 보기에는 어려움 (보통은 서블릿 컨테이너 개입이 필요함)
        // 하지만 타임리프는 서블릿 컨테이너에 독립적인 템플릿 엔진이라서 가짜 서블릿 컨테이너를 만들어 확인을 할 수 있음
    }

    @Test
    public void htmlunitTest() throws IOException {
        HtmlPage page = webClient.getPage("/hello");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");
        assertThat(h1.getTextContent()).isEqualTo("larry");
    }

}