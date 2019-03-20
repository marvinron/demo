package com.example.demo.common.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author houlei
 * @DESC:排队任务
 * @create 2019-01-08 16:41
 */
public class QueueTaskDemo implements Runnable {

    private CountDownLatch countDownLatch;

    public QueueTaskDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
            System.out.println("排队去抓药。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(countDownLatch != null){
                countDownLatch.countDown();
            }
        }

    }

    public static void main(String[] args) throws Exception{

        long oldTime = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new SeeDoctorTask(countDownLatch));
        executorService.execute(new QueueTaskDemo(countDownLatch));
        countDownLatch.await();
        System.out.println("看完病回家==="+(System.currentTimeMillis()-oldTime));
    }
}
