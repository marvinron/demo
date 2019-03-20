package com.example.demo.common;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Console;
import java.util.Arrays;
import java.util.List;


public class SessionHandlerThreadLocal {
   private static  Logger logger = LoggerFactory.getLogger(SessionHandlerThreadLocal.class);
    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<>();
    @Data
    public static class Session{
        private String id;
        private String user;
        private String status;
    }

    public Session createSession(){
        return new Session();
    }

    public String getUser(){
        return sessionThreadLocal.get().getUser();
    }

    public String getStatus(){
        return sessionThreadLocal.get().getStatus();
    }
    public void setStatus(String status){
        sessionThreadLocal.get().setStatus(status);
    }

    public static void main(String[] args) throws Exception {
        /*new Thread(()->{
            SessionHandlerThreadLocal sessionHandler = new SessionHandlerThreadLocal();
            Session session = sessionHandler.createSession();
            session.getStatus();
            session.getUser();
            session.setStatus("close");
            session.getStatus();

        }).start();*/

//        System.in.read();
        Console console = System.console();
//        String s = console.readLine();
        System.out.println(console);
        List<String> list = Arrays.asList("1","w","e","r");
        List<String> list1 = list.subList(1, 3);
        list1.stream().forEach(System.out::println);


    }
}
