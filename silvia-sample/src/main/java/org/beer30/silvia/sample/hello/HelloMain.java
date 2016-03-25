package org.beer30.silvia.sample.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Created by tsweets on 3/24/16.
 */
@SpringBootApplication
public class HelloMain {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(HelloMain.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
