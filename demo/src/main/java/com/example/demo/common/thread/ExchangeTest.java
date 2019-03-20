package com.example.demo.common.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-15 15:53
 */
public class ExchangeTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Exchanger exchanger = new Exchanger();
        executorService.execute(()->{

        });
    }
}
