package com.rapdog.rapbot;

import love.forte.simboot.autoconfigure.EnableSimbot;
import love.forte.simbot.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author rapdog
 */
@EnableSimbot
@SpringBootApplication
@ComponentScan({"com.rapdog.rapbot","com.rapdog.rapbot.listener","com.rapdog.rapbot.mapper"})
public class RapbotApplication {

    private static final Logger logger = LoggerFactory.getLogger(RapbotApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RapbotApplication.class, args);
    }

}
