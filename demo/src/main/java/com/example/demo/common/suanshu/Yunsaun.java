package com.example.demo.common.suanshu;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-19 15:11
 */
public class Yunsaun {

    public static void main(String[] args) {
        int a = 2;
        int b = 5;
       int c = (a ^ b) + ((a & b) << 1);
        System.out.println("a+b= "+c);
    }
}
