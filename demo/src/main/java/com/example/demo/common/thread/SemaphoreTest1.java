package com.example.demo.common.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-15 15:11
 */
public class SemaphoreTest1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(2,false);
        for (int i = 0; i < 5; i++) {
            executorService.execute(()->{
                System.out.println("尝试获取许可证。。。");
                try {
                    semaphore.acquire();
                    Thread.sleep(1000);
                    System.out.println("尝试释放许可。。。。。");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
