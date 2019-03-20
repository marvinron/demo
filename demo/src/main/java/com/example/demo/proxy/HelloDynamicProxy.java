package com.example.demo.proxy;

import com.example.demo.impl.HelloImpl;
import com.example.demo.interdace.HelloInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloDynamicProxy implements InvocationHandler {
    private Object subject;

    public HelloDynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic proxy "+method.getName());
        method.invoke(subject,args);
        System.out.println("dynamic proxy "+method.getName());
        return null;
    }

    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        InvocationHandler handler = new HelloDynamicProxy(hello);
        HelloInterface o = (HelloInterface) Proxy.newProxyInstance(handler.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
        o.sayHello();
    }
}
