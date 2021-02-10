package me.lkaybob.errorhandlerdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/hello")
    public String hello() {
        throw new SampleException();
    }

    // 이 Controller에서만 사용할 수 있음
    // 5xx.html은 아래를 주석 처리하면 뜨게 됨
    // 즉, 기본 에러 페이지는 모든 것들을 찾아보고 최후의 수단에서 사용한다고 함
    @ExceptionHandler(SampleException.class)
    public @ResponseBody AppError sampleError(SampleException s) {
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("IDK");
        return appError;
    }

}
