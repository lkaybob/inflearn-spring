package me.lkaybob.springtest.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 주의
public class SampleController {

    Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SampleService sampleService;

    @GetMapping("/hello")
    public String hello() {
        logger.info("holoman");
        System.out.println("skip"); // 이러면 안 되지만... 이것도 캡쳐가 된다는 의미에서...!
        return "hello " + sampleService.getName();
    }
}
