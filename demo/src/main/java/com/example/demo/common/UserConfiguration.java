package com.example.demo.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class UserConfiguration {
    @Bean(name="user")
    public User getUser(){
        User user = new User();
        user.setId(10);
        user.setName("小马");
        user.setDate(new Date());
        return user;

    }
}
