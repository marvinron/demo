package com.example.demo.common;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-01 15:01
 */
public class CalTest {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.home"));

    }

    private static void getTwoNum(int[] arry, int sum) {
        //用第一个数和最后一个数相加  如果大于sum  则不再和最后一个数相加 用第一个数和倒数第二个数相加
        int i = 0;
        int j = arry.length - 1;
        int currentSum =0;
        while (i < j) {
            currentSum= arry[i]+arry[j];
            if(currentSum == sum){
                System.out.println("第一个数是 "+arry[i]+"第二个数是 "+arry[j]);
                break;
            }
            if(currentSum<sum){
                i++;
            }else {
                j--;
            }

        }


    }
}
