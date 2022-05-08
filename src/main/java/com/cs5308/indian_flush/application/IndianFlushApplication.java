package com.cs5308.indian_flush.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import com.cs5308.indian_flush.implementation.playbyturn.abstractfactory.TurnManagerAbstractFactory;

/* @Author: Vikram */
@SpringBootApplication
@PropertySource(value = "classpath:${spring.profiles.active}/service.config.properties")
@ComponentScan(basePackages = {"com.cs5308.*"})
public class IndianFlushApplication implements CommandLineRunner {

    private static Logger LOGGER = LoggerFactory.getLogger(IndianFlushApplication.class);

    private final String DEPLOY_KEYWORD = "deploy";

    public static void main(String[] args) {
        SpringApplication.run(IndianFlushApplication.class, args);
    }

    /* @Author: Meshwa Savalia */
    @Override
    public void run(String... args) throws Exception {

        if (args != null && args[0] != null && args[0].equalsIgnoreCase(DEPLOY_KEYWORD)) {
            LOGGER.info("Indian Flush Application Deployed Successfully!");
        } else {
            TurnManagerAbstractFactory.instance().createTurnManager().initiateGame();
        }
    }
}
