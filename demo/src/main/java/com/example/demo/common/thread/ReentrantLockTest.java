package com.example.demo.common.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author houlei
 * @DESC:ReentrantLockTest 测试
 * @create 2019-01-10 16:05
 */
public class ReentrantLockTest extends Thread {
    private ReentrantLock lock = new ReentrantLock();
    private static int i=0;

    public ReentrantLockTest(String name) {
        super.setName(name);
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            lock.lock();
            try{
                System.out.println(this.getName()+" "+i);
                i++;

            }finally {
                lock.unlock();

            }

        }

    }

    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest1 = new ReentrantLockTest("thread-1");
        ReentrantLockTest reentrantLockTest2 = new ReentrantLockTest("thread-2");
        reentrantLockTest1.start();
        reentrantLockTest2.start();
        try {
            reentrantLockTest1.join();
            reentrantLockTest2.join();
            System.out.println("result "+i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }






}
