package com.example.demo.common.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockConditionDemo {
    private Lock lock = new ReentrantLock();
    private Condition providerCondition = lock.newCondition();
    private Condition consumerCondition = lock.newCondition();
    private static List<String> list = new ArrayList<>();

    public void put(String str) throws Exception {
        Thread.sleep(200);
        lock.lock();
        try {
            while (list.size() != 0) {
                System.out.println("生产者等待。。。");
                providerCondition.await();
            }
            System.out.println("写入数据。。。。");
            list.add(str);
            consumerCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }

    }

    public void get() throws Exception {
        Thread.sleep(200);
        lock.lock();
        try {
            while (list.size() == 0) {
                System.out.println("数据消费完毕，暂停读取。。。");
                consumerCondition.await();
            }
            System.out.println("读取数据。。。");
            list.remove(0);
            providerCondition.signal();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws Exception {
        ReentrantLockConditionDemo reentrantLockConditionDemo = new ReentrantLockConditionDemo();
        //创建一个消费者线程
        for (int i = 0; i < 1; i++) {
            new Thread(()->{
                try {
                    reentrantLockConditionDemo.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        }

        //创建10个生产者线程
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    reentrantLockConditionDemo.put("123456");
                } catch (Exception e) {


                }
            }).start();

        }


    }
}
