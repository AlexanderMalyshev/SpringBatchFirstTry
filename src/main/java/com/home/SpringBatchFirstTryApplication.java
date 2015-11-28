package com.home;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableBatchProcessing
//@ImportResource("classpath:/context/batch.xml")
public class SpringBatchFirstTryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchFirstTryApplication.class, args);
    }
}
