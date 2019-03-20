package com.example.demo.single;


import java.util.HashSet;
import java.util.Set;

/**
 * 这种方式在多线程环境中容易出现问题 当一个线程在判断实例等于null的情况下  让出时间片  另外一个线程进入new 等再次执行的时候又new了一个  在多线程中会出现两个实例
 */
public class SingleOne {
    private static SingleOne singleOne;
    private SingleOne(){}
    public static SingleOne getInstance(){
        if(singleOne == null){
            singleOne = new SingleOne();
        }
        return singleOne;

    }

    public static void main(String[] args) throws Exception{
        //多线程测试懒汉式的加载

        Set<SingleOne> set = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                set.add(SingleOne.getInstance());
            }).start();

        }
        Thread.sleep(1000);
        for(SingleOne singleOne:set){
            System.out.println(singleOne);
        }

    }
}
