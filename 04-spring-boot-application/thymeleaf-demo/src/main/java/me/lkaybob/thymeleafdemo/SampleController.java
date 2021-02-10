package me.lkaybob.thymeleafdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // RestController가 아님!
public class SampleController {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "larry");
        return "hello";
    }
}
