package org.beer30.silvia.sample.hello;


import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by tsweets on 3/25/16.
 */

@Configuration
@EnableBatchProcessing
@ImportResource({"classpath:META-INF/spring/hello-sample-job.xml"})
public class HelloConfig {


}
