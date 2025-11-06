package com.matiaspakua.content_calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        // showBeansInformation(context);
    }

    private static void showBeansInformation(ConfigurableApplicationContext context) {
        int count = context.getBeanDefinitionCount();
        System.out.println(count);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

}
