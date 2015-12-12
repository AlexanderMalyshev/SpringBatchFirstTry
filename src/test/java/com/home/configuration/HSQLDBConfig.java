package com.home.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class HSQLDBConfig {
    @Bean(name = "dataSource")
    @Profile("embedded")
    // -Dspring.profiles.active=embedded
    public DataSource inMemoryDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).addScript("/schema-hsql.sql").build();
    }

    @Bean(name = "dataSource")
    @Profile("hsqldb")
    // --Dspring.profiles.active=hsqldb
    public DataSource hsqldbDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        driverManagerDataSource.setUrl("jdbc:hsqldb:hsql://localhost:9001/mydb");
        driverManagerDataSource.setUsername("SA");
        driverManagerDataSource.setPassword("");
        return driverManagerDataSource;
    }
}
