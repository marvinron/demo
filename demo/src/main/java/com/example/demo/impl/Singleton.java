package com.example.demo.impl;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author houlei
 * @DESC:不使用synchronised和volatile的单例
 * @create 2019-02-27 9:38
 */
public class Singleton {
    private static final AtomicReference<Singleton> atomicReference = new AtomicReference<>();
    private Singleton(){}
    public static Singleton getSingleton(){
        for(;;){
            Singleton singleton = atomicReference.get();
            if(singleton != null){
                return singleton;
            }
            singleton = new Singleton();
            if(atomicReference.compareAndSet(null,singleton)){

                return singleton;
            }

        }

    }
}
