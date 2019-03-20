package com.example.demo.common.thread;

import com.example.demo.params.User;

import java.beans.BeanInfo;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author houlei
 * @DESC:创建线程
 * @create 2019-01-08 10:56
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在执行。。。");
    }

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

//            executorService.execute(new MyThread());
//            executorService.schedule(new MyThread(),100,TimeUnit.SECONDS);
            executorService.scheduleAtFixedRate(new MyThread(),0,1,TimeUnit.SECONDS);

//        executorService.shutdown();
        User user = new User();
        Field[] declaredFields1 = User.class.getDeclaredFields();
        Stream.of(declaredFields1).forEach(System.out::println);
    }
}
