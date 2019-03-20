package com.example.demo.common.limit;

import java.util.concurrent.Semaphore;

/**
 * @author houlei
 * @DESC:信号量
 * @create 2019-02-22 14:52
 */
public class RateLimiter {
    private Semaphore semaphore;

    public RateLimiter(int  permits) {
        semaphore = new Semaphore(permits);
    }
    public void acquired(int  permits)throws Exception{
        semaphore.acquire(permits);
    }
    public void release(int permits){
        semaphore.release(permits);
    }
}
