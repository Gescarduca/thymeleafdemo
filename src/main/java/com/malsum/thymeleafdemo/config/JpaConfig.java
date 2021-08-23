package com.malsum.thymeleafdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

//this class serves mostly to create a datasource object which you need to pass to spring security to tell it where to get info necessary to authenticate users
@Configuration
public class JpaConfig {

    //primary database
    @Primary
    //bean in spring
    @Bean
    //from the properties file pick only those that have start with app.datasource
    @ConfigurationProperties(prefix="app.datasource")
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/employee_directory?useSSL=false&serverTimezone=UTC");
        dataSourceBuilder.username("springstudent");
        dataSourceBuilder.password("springstudent");
        return dataSourceBuilder.build();
    }

    @Bean
    @ConfigurationProperties(prefix="security.datasource")
    public DataSource securityDataSource() {
        return DataSourceBuilder.create().build();
    }

}
