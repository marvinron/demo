package com.example.demo.common.thread;


import java.util.ArrayList;
import java.util.List;

public class SynchronizedProviderDemo implements Runnable {

    public static List<String> cache = new ArrayList<>();

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Thread.sleep(10);
                synchronized (cache) {
                    if (cache.size() < 1) {
                        //进行生产
                        System.out.println("进行生产====");
                        cache.add(new String("provider"));
                        cache.notifyAll();
                    } else {
                        //进行等待
                        System.out.println("等待消费===");
                        cache.wait();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

   static class SynchronizedConsumerDemo implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    Thread.sleep(10);
                    synchronized (cache) {
                        if (cache.size() == 0) {
                            //消费完毕 等待
                            System.out.println("消费完毕 等待。。。");
                            cache.wait();

                        }else {
                            System.out.println("开始消费。。。");
                            cache.get(0);
                            cache.remove(0);
                            //消费之后唤醒
                            cache.notifyAll();

                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

     public static void main(String[] args) {
        Thread thread = new Thread(new SynchronizedProviderDemo());
        Thread thread1 = new Thread(new SynchronizedConsumerDemo());
        thread.start();
        thread1.start();

     	}
}



