package com.example.demo.impl;

import com.example.demo.interdace.HelloInterface;

public class HelloImpl implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("hello impl");
    }
}
