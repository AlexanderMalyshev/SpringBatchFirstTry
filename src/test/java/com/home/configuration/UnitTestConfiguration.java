package com.home.configuration;

import com.home.data.PersonDao;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackageClasses=PersonDao.class)
@ImportResource("classpath:/db-context.xml")
public class UnitTestConfiguration {
}
