package me.lkaybob.externalconfigurationexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@EnableConfigurationProperties(KaybobProperties.class)
public class SampleRuner implements ApplicationListener<ApplicationStartedEvent> {

    @Value("${kaybob.name}")
    private String name;

    @Autowired
    private KaybobProperties kaybobProperties;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("=================");
        System.out.println("Application started " + kaybobProperties.getFullName());
        System.out.println(kaybobProperties.getAge());
        System.out.println(kaybobProperties.getSessionTimeout());
        System.out.println("=================");
    }
}
