package com.example.demo.common.limit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houlei
 * @DESC:Action
 * @create 2019-02-22 14:56
 */
public class Action {
    private RateLimiter rateLimiter;

    public Action() {
        rateLimiter = new RateLimiter(3);
    }
    public void doSomething(){
        try {
             rateLimiter.acquired(1);
            System.out.println("do something ing ....");
            Thread.sleep(1000);
        }catch (Exception e){

        }finally {
            rateLimiter.release(1);
        }
    }

    public static void main(String[] args) {
        Action action = new Action();
        List<Thread> threadList = new ArrayList<>();
        try {
            for (int i = 0; i < 100; i++) {
                threadList.add(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        action.doSomething();
                    }
                }));
            }
            for(Thread thread:threadList){
                thread.start();
            }
            for(Thread thread:threadList){
                thread.join();
            }
        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
