package com.example.demo.single;


//在懒汉模式中  把获取单例的方法加上所  但有性能损耗 每次获取的时候都要进行线程等待
public class SingleThree {
    private static SingleThree singleThree;
    private SingleThree(){}
    public static synchronized SingleThree getSingleThree(){
        if(singleThree == null){
            singleThree = new SingleThree();
        }
        return singleThree;
    }
}
