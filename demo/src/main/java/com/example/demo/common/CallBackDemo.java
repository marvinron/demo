package com.example.demo.common;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public  class CallBackDemo {
    public static void main(String[] args) {
        CallBackExecutor callBackExecutor = new CallBackExecutor();
        callBackExecutor.execute(()->System.out.println("hello"));
        callBackExecutor.execute(()->System.out.println("ABC"));
        callBackExecutor.run();
        Object o = "str";
        if(o instanceof String){
            System.out.println(o);
        }

//        System.out.println("hello world");


    }

    //创建一个回调接口
    public interface CallBack{
        void callBack();
    }
    private static class CallBackExecutor{
        private Queue<CallBack> callBackQueue = new LinkedList<>();
        public void execute(CallBack callBack){
            callBackQueue.add(callBack);
        }
        public void run(){
            callBackQueue.forEach(callBack -> {
                callBack.callBack();
            });
        }
    }




}
