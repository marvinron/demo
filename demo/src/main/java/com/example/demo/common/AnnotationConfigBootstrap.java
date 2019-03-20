package com.example.demo.common;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigBootstrap {
    public static void main(String[] args) {

        /*AnnotationConfigApplicationContext annotationConfigApplicationContext= new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(UserConfiguration.class);
        annotationConfigApplicationContext.refresh();
        User bean = annotationConfigApplicationContext.getBean(User.class);
        String name = bean.getName();
        System.out.println(name+"====");*/
        System.out.println(System.getProperty("user.home"));
    }
}
