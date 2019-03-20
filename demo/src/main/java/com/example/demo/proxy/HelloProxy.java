package com.example.demo.proxy;

import com.example.demo.impl.HelloImpl;
import com.example.demo.interdace.HelloInterface;

public class HelloProxy implements HelloInterface {
    private HelloInterface hello= new HelloImpl();
    @Override
    public void sayHello() {
        System.out.println(" before proxy say hello");
        hello.sayHello();
        System.out.println("after proxy say hello");

    }

    public static void main(String[] args) {
        HelloProxy helloProxy = new HelloProxy();
        helloProxy.sayHello();
    }
}
