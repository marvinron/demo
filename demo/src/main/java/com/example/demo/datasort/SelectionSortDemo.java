package com.example.demo.datasort;

import java.util.Arrays;

/**
 * 选择排序：
 * 1.从待排序中找到关键字最小的元素
 * 2.如果最小的元素不是待排序序列中的第一个元素 将其和第一个元素交换
 * 3.从于下的n-1个元素中找出关键字最小的元素  重复1、2步骤 直到结束
 */
public class SelectionSortDemo {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min =j;

                }

            }
            if(min !=i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;

            }

        }
        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int[] arr = {3,4,6,2,32,12,42,34,5};
        selectionSort(arr);
    }

}
