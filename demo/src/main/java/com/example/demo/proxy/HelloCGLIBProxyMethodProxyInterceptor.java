package com.example.demo.proxy;

import com.example.demo.impl.HelloImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HelloCGLIBProxyMethodProxyInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB代理的执行方法 before" + method.getName());
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("CGLIB代理的执行方法 after" + method.getName());
        return o1;
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloImpl.class);
        enhancer.setCallback(new HelloCGLIBProxyMethodProxyInterceptor());
        HelloImpl hello = (HelloImpl) enhancer.create();
        hello.sayHello();
    }
}
