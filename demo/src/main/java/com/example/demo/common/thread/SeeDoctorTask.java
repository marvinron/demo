package com.example.demo.common.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author houlei
 * @DESC:countdown测试
 * @create 2019-01-08 16:37
 */
public class SeeDoctorTask implements Runnable {

    private CountDownLatch countDownLatch;

    public SeeDoctorTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("看大夫成功，大夫开了些药单。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(countDownLatch != null){
                countDownLatch.countDown();
            }
        }

    }




}
