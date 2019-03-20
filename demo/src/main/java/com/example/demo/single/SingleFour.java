package com.example.demo.single;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-11 10:30
 */
public class SingleFour {
    private static volatile SingleFour singleFoure;
    private SingleFour(){}
    public static SingleFour singleFoure(){
        //多线程访问  不做判断
        if(singleFoure == null){
            //此时如果多线程访问 允许一个线程进入
            synchronized (SingleFour.class){
                //如果第一个线程进来是null  第二个线程进来就不是null了
                if(singleFoure == null){
                    singleFoure = new SingleFour();
                }
            }
        }
        return singleFoure;
    }
}
