package com.example.demo.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class CGlibDynamicProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB代理的执行方法 "+method.getName());
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("CGLIB代理后的执行方法 "+method.getName());
        return o1;
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BuyHouse.class);
        enhancer.setCallback(new CGlibDynamicProxy());
        BuyHouse o = (BuyHouse)enhancer.create();
        o.buyHouse();
    }
}
