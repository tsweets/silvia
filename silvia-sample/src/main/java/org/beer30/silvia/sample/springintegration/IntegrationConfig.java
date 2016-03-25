package org.beer30.silvia.sample.springintegration;


import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by tsweets on 3/25/16.
 */

@Configuration
@EnableBatchProcessing
@ImportResource({"classpath:META-INF/spring/hello-sample-integration-job.xml","classpath:META-INF/spring/hello-sample-integration.xml"})
public class IntegrationConfig {


    @Bean
    public DataSource dataSource() {
        final EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:/org/springframework/batch/core/schema-drop-hsqldb.sql")
                .addScript("classpath:/org/springframework/batch/core/schema-hsqldb.sql")
                .addScript("classpath:database/db-init.sql");


        return builder.build();
    }

}
