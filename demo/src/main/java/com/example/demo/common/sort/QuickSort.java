package com.example.demo.common.sort;


import java.util.stream.Stream;

public class QuickSort {

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        while (low<high){
            while (low<high && arr[high]>=pivot){
                --high;
            }
            arr[low]=arr[high];
            while (low<high && arr[low]<=pivot){
                ++low;
            }
            arr[high] = arr[low];
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }

    public static void qSort(int[] arr,int low,int high){
        if(low<high){
            int privod= partition(arr,low,high);
            qSort(arr,low,privod-1);
            qSort(arr,privod+1,high);

        }

    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 10, 13, 9, 20};
        qSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
