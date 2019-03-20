package com.example.demo.proxy;

/**
 * @author houlei
 * @DESC:Marry类
 * @create 2019-01-16 9:29
 */
public class BuyHouse implements BuyInterface {
    @Override
    public void buyHouse(){
        System.out.println("我要买房！");
    }
}
