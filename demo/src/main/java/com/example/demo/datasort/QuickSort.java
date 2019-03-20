package com.example.demo.datasort;

import java.util.Arrays;

/**
 * @author houlei
 * @DESC:
 * @create 2019-03-19 11:49
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,2,32,21,3,4,23,231,3,41};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr) {
        recurPartion(arr,0,arr.length-1);


    }

    public static int parseArr(int[] arr, int start, int end) {
        //选取基准元素 以最后一个元素为基准
        int base = arr[end];
        //记录比基准元素小的变量 这里我们假设比较的元素不小于基准元素
        int n = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < base) {
                //小于基准元素的放到基准元素的左边
                if (i != n) {
                    //进行交换
                    exchangeE(arr, i, n);
                    //交换之后n进行加一
                    n++;
                }

            }
        }
        //遍历完成之后将元素放到应该的位置上
        exchangeE(arr, n, end);
        return n;
    }

    public static void recurPartion(int[] arr, int start, int end) {
        if (end - start < 1) {
            return;
        }
        int part = parseArr(arr,start,end);
        if(part == start){
                    recurPartion(arr,part+1,end);

        }else if(part == end){
            recurPartion(arr,start,end-1);
        }else {
            recurPartion(arr,start,part-1);
            recurPartion(arr,part+1,end);
        }

    }

    public static void exchangeE(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
