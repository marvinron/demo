package com.example.demo.common.thread;

public interface ThreadFactory {
    public Thread newThread(Runnable runnable);
}
