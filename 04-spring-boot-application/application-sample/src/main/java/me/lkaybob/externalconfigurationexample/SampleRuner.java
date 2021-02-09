package me.lkaybob.externalconfigurationexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(SampleRuner.class);

    @Value("${kaybob.name}")
    private String name;

    @Autowired
    private KaybobProperties kaybobProperties;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        logger.debug("=================");
        logger.debug("Application started " + kaybobProperties.getFullName());
        logger.debug(String.format("%d", kaybobProperties.getAge()));
        logger.debug(kaybobProperties.getSessionTimeout().toString());
        logger.debug("=================");
    }
}
