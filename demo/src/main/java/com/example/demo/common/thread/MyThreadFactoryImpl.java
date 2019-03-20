package com.example.demo.common.thread;


public class MyThreadFactoryImpl implements ThreadFactory {
    @Override
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable);
    }


}
