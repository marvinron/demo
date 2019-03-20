package com.example.demo.common.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-18 9:50
 */
public class ProducerAndConsumerDemo {

    public static void main(String[] args)  {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,1000,TimeUnit.SECONDS,new ArrayBlockingQueue(10));
        Container container = new Container();
        threadPoolExecutor.execute(()->{

            container.producer();
        });
        threadPoolExecutor.execute(()->{
            container.consume();
        });
        threadPoolExecutor.shutdown();
    }


    private static class Container {
        private List<Integer> data = new ArrayList();
        private final Integer Max_SIZE = 5;
        Random random = new Random();

        public void producer() {
            while (true) {
                synchronized (this) {
                    if (data.size() >= Max_SIZE) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    int value = random.nextInt(1000);
                    System.out.printf("当前线程[%s]正在生产数据：%d\n", Thread.currentThread().getName(), value);
                    data.add(value);
                    notifyAll();


                }
            }
        }

        public void consume() {
            while (true) {
                synchronized (this) {
                    if (data.size() <= 0) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                    data.remove(0);
                    System.out.printf("消费者[%s]正在消费数据",Thread.currentThread().getName());
                    notifyAll();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
