package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author houlei
 * @DESC:JDk的动态代理
 * @create 2019-01-16 10:23
 */
public class JDKDynamicProxy implements InvocationHandler {
    //持有目标类
    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理的方法 "+method.getName());
        method.invoke(target,args);

        return null;
    }

    public static void main(String[] args) {
        BuyInterface buyInterface = new BuyHouse();
        InvocationHandler invocationHandler = new JDKDynamicProxy(buyInterface);
        BuyInterface buyInterface1 = (BuyInterface)Proxy.newProxyInstance(buyInterface.getClass().getClassLoader(), buyInterface.getClass().getInterfaces(), invocationHandler);

        buyInterface1.buyHouse();
    }
}
