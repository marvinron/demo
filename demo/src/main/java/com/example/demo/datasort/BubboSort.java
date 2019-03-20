package com.example.demo.datasort;

import java.util.Arrays;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-19 11:30
 */
public class BubboSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 44, 32, 45, 6, 77, 34, 1};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                }
            }

        }

        System.out.println(Arrays.toString(arr));
    }
}
