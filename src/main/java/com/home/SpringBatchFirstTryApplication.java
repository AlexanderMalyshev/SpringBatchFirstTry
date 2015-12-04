package com.home;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@EnableBatchProcessing
@SpringBootApplication
public class SpringBatchFirstTryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchFirstTryApplication.class, args);
    }
}
