package com.example.demo.params;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Executor;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();

        ServletContext servletContext = request.getServletContext();

        servletContext.log("request was initialized!");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();

        ServletContext servletContext = request.getServletContext();

        servletContext.log("request was destroyed!");

    }

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        while (true) {

            System.out.println(classLoader.getClass().getName());

            classLoader = classLoader.getParent();

            if (classLoader == null) {
                break;
            }

        }

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        System.out.println(systemClassLoader.getClass().getName());
    }
}
