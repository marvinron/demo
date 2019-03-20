package com.example.demo.common.thread;


public class TurnPrint2 {

    private static int count = 0;
    private static final Object OBJECT = new Object();

    public static void main(String[] args) throws Exception {
        new Thread(()->{
            while (count<100){
                synchronized (OBJECT){
                    System.out.println(Thread.currentThread().getName()+"====="+(count++));
                    OBJECT.notifyAll();
                    if(count<=100){
                        try {
                            OBJECT.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        },"偶数线程").start();
        Thread.sleep(1);

        new Thread(()->{
            while (count<100){
                synchronized (OBJECT){
                    System.out.println(Thread.currentThread().getName()+"====="+(count++));
                    OBJECT.notifyAll();
                    if(count<=100){
                        try {
                            OBJECT.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        },"奇数线程").start();

    }
}
