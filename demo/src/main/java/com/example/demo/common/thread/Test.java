package com.example.demo.common.thread;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-15 9:52
 */
public class Test {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("===========");
        });
        //线程多次start会出现非法状态的异常
        thread.start();
        thread.start();


    }
}
