package com.example.demo.common.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author houlei
 * @DESC:Semaphore的测试
 * @create 2019-01-17 16:04
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //使用并发库 创建缓存的线程池
        ExecutorService service = Executors.newCachedThreadPool();
        //创建semapher的信号量 设置访问的最大值
        int n=3;
        Semaphore semaphore = new Semaphore(n);
        //查看并发的访问次数
        System.out.println("该时刻共有"+(n-semaphore.availablePermits())+"个线程正在访问 ");
        //创建10个线程任务
        for (int i = 0; i < 10; i++) {
            //记录第几个任务
           int NO = i;
            //具体任务
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"获取许可 "+"("+NO+")"+"剩余 "+semaphore.availablePermits());
                        Thread.sleep(1000);
                        //使用完进行释放
                        semaphore.release();
                        System.out.println(Thread.currentThread().getName()+"释放许可 "+"("+NO+")"+"剩余 "+semaphore.availablePermits());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            };
            service.execute(runnable);
        }
        service.shutdown();
    }
}
