package com.example.demo.datasort;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-19 9:17
 */

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 1.从第一个元素开始 这个元素已经排序
 * 2.取出下个元素 在已经排序号的元素从后向前扫描
 * 3.如果该元素大于新元素 将该元素移动到下一位
 * 4.重复步骤三 直到找到小于或者等于该元素
 * 5.将新元素插入到该元素的位置
 * 6.重复2-5的步骤
 */
public class InsertSortDemo {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && arr[j - 1] > temp) {
                    arr[j] = arr[j-1];

                }else{
                    arr[j] =temp;
                    break;

                }


            }

        }



    }

    public static void main(String[] args) {
        int[] arr={2,7,4,23,6,8,3,23,5,6};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
