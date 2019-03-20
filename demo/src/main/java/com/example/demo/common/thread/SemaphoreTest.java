package com.example.demo.common.thread;

import java.util.concurrent.Semaphore;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-15 15:39
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("获取资源====");
                Thread.sleep(1000);

                semaphore.release();
                System.out.println("释放资源====");
            } catch (Exception e) {
                e.printStackTrace();
            }

        },"thread-1").start();

        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("获取资源====");
                Thread.sleep(1000);

                semaphore.release();
                System.out.println("释放资源====");
            } catch (Exception e) {
                e.printStackTrace();
            }

        },"thread-2").start();

        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("获取资源====");
                Thread.sleep(1000);

                semaphore.release();
                System.out.println("释放资源====");
            } catch (Exception e) {
                e.printStackTrace();
            }

        },"thread-3").start();
    }
}
