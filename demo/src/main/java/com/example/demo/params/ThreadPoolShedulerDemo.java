package com.example.demo.params;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolShedulerDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.scheduleAtFixedRate(new Myscheduler(),1000,2000, TimeUnit.MILLISECONDS);
    }


   static class Myscheduler implements Runnable{

        @Override
        public void run() {
            System.out.println("执行 "+new Date());
        }
    }
}
