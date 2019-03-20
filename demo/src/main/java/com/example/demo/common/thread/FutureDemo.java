package com.example.demo.common.thread;

import java.util.concurrent.*;

/**
 * @author houlei
 * @DESC:获取线程异步执行结果
 * @create 2019-01-10 9:16
 */
public class FutureDemo {
    public static void main(String[] args) throws InterruptedException {
        TaskDemo taskDemo = new TaskDemo();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(taskDemo);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(futureTask);

        Thread.sleep(1000);
        try {
            System.out.println("future.get() "+futureTask.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
