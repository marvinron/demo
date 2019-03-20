package com.example.demo.common.thread;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author houlei
 * @DESC:
 * @create 2019-02-15 14:43
 */
public class ThreadAndPoolTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        final List<Integer> list = new LinkedList<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,60,TimeUnit.SECONDS,new LinkedBlockingQueue<>(10000));
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            threadPoolExecutor.execute(()->{
                list.add(random.nextInt());
            });

        }
        threadPoolExecutor.shutdown();
        System.out.println(System.currentTimeMillis()-start);
    }
    @Test
    public void test(){
        long start = System.currentTimeMillis();
        final List<Integer> list = new LinkedList<>();
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(random.nextInt());
            }).start();

        }
        System.out.println(System.currentTimeMillis()-start);

    }
}
