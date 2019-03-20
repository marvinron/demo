package com.example.demo.common.pattern;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AccountProxyFactory implements InvocationHandler {

    public Object getInstance(Object object){

        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法之前。。。。");
        method.invoke(proxy,args);
        System.out.println("执行方法之后。。。。");
        return null;
    }
}
