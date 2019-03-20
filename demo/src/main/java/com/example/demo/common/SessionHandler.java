package com.example.demo.common;

import lombok.Data;
import org.apache.commons.lang3.time.FastDateFormat;

public class SessionHandler {
    @Data
    public static class Session{
        private String id;
        private String user;
        private String status;
    }

    public Session createSession(){
        return new Session();
    }

    public String getUser(Session session){
        return session.getUser();
    }

    public String getStatus(Session session){
        return session.getStatus();
    }
    public void setStatus(Session session,String status){
        session.setStatus(status);
    }

    public static void main(String[] args) {
        new Thread(()->{
            SessionHandler sessionHandler = new SessionHandler();
            Session session = sessionHandler.createSession();
            sessionHandler.getStatus(session);
            sessionHandler.getUser(session);
            sessionHandler.setStatus(session,"close");
            sessionHandler.getStatus(session);

        }).start();
    }




}
