package org.beer30.silvia.sample.springintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by tsweets on 3/24/16.
 */
@SpringBootApplication
public class IntegrationMain {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(IntegrationMain.class, args);
    }
}
