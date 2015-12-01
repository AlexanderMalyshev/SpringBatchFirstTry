package com.home.configuration;

import com.home.data.PersonDao;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses=PersonDao.class)
@ImportResource(locations={"classpath:/hsqldb.xml", "classpath:/db-context.xml"})
public class IntegrationTestConfiguration {
}
