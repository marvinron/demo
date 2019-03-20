package com.example.demo.common.suanshu;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-19 15:17
 */
public class FactorialDemo {

    public static void main(String[] args) {
        FactorialDemo factorialDemo = new FactorialDemo();
        long factorial = factorialDemo.factorial(10);
        System.out.println("阶乘的结果 "+factorial+"==");
        int zeroCount = factorialDemo.getZeroCount(factorial);
        System.out.println("0的个数是 "+zeroCount);
       /* long trailing = factorialDemo.trailing(50);
        System.out.println(trailing+"=====");*/

    }

    private int getZeroCount(long num) {

        boolean flag = true;
        int zeroCount = 0;
        do {
            if (num % 10 == 0) {
                num = num/10;
                zeroCount++;
            } else {
                flag = false;
            }
        } while (flag);
        return zeroCount;


    }

    public long factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * factorial(num - 1);

    }

    public long trailing(long n){
        long count =0;
        long temp = n/5;
        while(temp !=0){
            count += temp;
            temp /=5;
        }
        return count;
    }
}
