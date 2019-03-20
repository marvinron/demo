package com.example.demo.common.suanshu;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-19 11:03
 */
public class YihuoDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("int a= " + a + " int b = " + b);
    }
}
