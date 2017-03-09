package my.javase.study.algorithm;

/**
 * Created by xpcomrade on 2016/7/21.
 * Copyright (c) 2016, xpcomrade@gmail.com All Rights Reserved.
 * Description: (快速排序). <br/>
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        System.out.println("排序之前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // 快速排序
        quickSort(arr, 0, arr.length - 1);

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end); // 将数组一分为2，返回枢轴值pivot所在的位置
            quickSort(arr, start, pivot - 1); // 对低位子序列递归排序
            quickSort(arr, pivot + 1, end); // 对高位子序列递归排序
        }
    }

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[start]; // 序列的第一条记录作为枢轴元素
        while (start < end) { // 从低位往高位遍历
            while (start < end && pivot <= arr[end]) { // 在高位找到比枢轴大的元素，符合要求，继续寻找
                end--;
            }
            arr[start] = arr[end];  //将比枢轴元素小的记录交换到低位
            while (start < end && pivot >= arr[start]) {  //在低位找到比枢轴小的元素，符合要求，继续寻找
                start++;
            }
            arr[end] = arr[start]; // 将比枢轴记录大的元素交换到高位
        }
        arr[start] = pivot; // 将枢轴放在正确的排序位置
        return start;  // 返回枢轴元素所在的位置
    }
}
