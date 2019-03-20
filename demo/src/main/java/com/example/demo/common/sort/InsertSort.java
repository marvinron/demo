package com.example.demo.common.sort;

import java.util.Arrays;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-11 11:37
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 10, 13, 9, 20};
        for (int i = 0; i < arr.length-1; i++) {
            int temp = arr[i+1];
            for (int j = i; j >= 0; j--) {
                if (temp < arr[j]) {
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }else {
                    arr[j+1]=temp;
                    break;
                }


            }

        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
