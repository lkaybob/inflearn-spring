package me.lkaybob.hateoasdemo;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class SampleController {
    @GetMapping("/hello")
    public EntityModel<Hello> hello() {
        Hello hello = new Hello();
        hello.setName("larry");
        hello.setPrefix("Mr.");

        // 생성자를 사용하는 것은 Deprecated됨
        // EntityModel<Hello> helloEntityModel = new EntityModel<>(hello);
        EntityModel<Hello> helloEntityModel = EntityModel.of(hello);
        helloEntityModel.add(linkTo(methodOn(SampleController.class).hello()).withSelfRel());

        return helloEntityModel;
    }
}