package com.example.demo.common.thread;

import java.util.concurrent.Callable;

/**
 * @author houlei
 * @DESC:线程执行demo
 * @create 2019-01-10 9:10
 */
public class TaskDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        //返回执行任务的结果
        int i =0;
        for (; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"_"+i);
            Thread.sleep(500);
        }
        return i;
    }
}
