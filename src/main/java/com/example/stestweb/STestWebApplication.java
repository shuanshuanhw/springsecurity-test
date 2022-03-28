package com.example.stestweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class STestWebApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext app = SpringApplication.run(STestWebApplication.class, args);
//        app.start();
//
//        app.stop();
//
//        app.start();
    }

}
