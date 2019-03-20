package com.example.demo.common.sort;


import java.util.Arrays;

public class BubboSort {
    public static void main(String[] args) {
       int[] arr = {7,2,5,10,13,9,20};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int temp =0;
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                }

            }

        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
