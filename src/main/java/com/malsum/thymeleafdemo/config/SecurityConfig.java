package com.malsum.thymeleafdemo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("securityDataSource")
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource);//use this datasource to authenticate users
        //new pass fun123
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //authorize which Url are valid for each role

        http.authorizeRequests()
                .antMatchers("/employees/showForm*").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/employees/save*").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/employees/delete").hasRole("ADMIN")
                .antMatchers("/employees/**").hasRole("EMPLOYEE")
                .antMatchers("/resources/**").permitAll()
                .and()
                    .formLogin()
                    .loginPage("/showLoginPage")//tells spring security to expect a custom page at this url, hence it stops creating a default page
                    //.loginProcessingUrl("/authenticateUser")
                    .defaultSuccessUrl("/hello",true)
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");

    }

    //===========================In memory AUTHENTICATION====================================
//    //create in memory authentication
//    //configure roles per URL
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // add in memory database kinda
//        User.UserBuilder users = User.withDefaultPasswordEncoder();//basically every user that is added has no encrypted password
//
//        auth.inMemoryAuthentication()
//                .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//                .withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
//                .withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));
//    }
//
//


}
