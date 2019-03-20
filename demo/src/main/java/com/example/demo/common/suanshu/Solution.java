package com.example.demo.common.suanshu;

import java.util.Arrays;

/**
 * @author houlei
 * @DESC:合并两个有序数组 生成一个有序数组
 * @create 2019-03-19 16:24
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5};
        int[] arr2 = {5,6,7,8,9,10};
        int[] merge = merge(arr1, arr1.length, arr2, arr2.length);
        System.out.println(Arrays.toString(merge));

    }

    public static int[] merge(int[] arr1, int m, int[] arr2, int n) {
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }

        }
        if (i != m) {
            while (i < m) {
                result[k++] = arr1[i++];

            }

        }
        if(j != n){
            while (j<n){
                result[k++] = arr2[j++];
            }
        }
        k=0;
        for (i= 0; i < arr1.length; i++) {
            arr1[i++] = result[k++];
            
        }
        return result;


    }

}
