package com.example.demo.common.thread;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-12 13:26
 */
public class TurnPrint {
    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while (count < 100) {
                synchronized (lock){
                    if (count % 2 == 0) {
                        System.out.println(Thread.currentThread().getName()+"==="+(count++));

                    }
                }

            }

        }, "偶数线程").start();
        new Thread(()->{
            while (count<100){
                synchronized (lock){
                    if(count %2 !=0){
                        System.out.println(Thread.currentThread().getName()+"==="+(count++));
                    }
                }
            }
        },"奇数线程").start();

    }
}
