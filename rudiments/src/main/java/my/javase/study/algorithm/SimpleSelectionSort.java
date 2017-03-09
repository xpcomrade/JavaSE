package my.javase.study.algorithm;

/**
 * Created by xpcomrade on 2016/7/21.
 * Copyright (c) 2016, xpcomrade@gmail.com All Rights Reserved.
 * Description: (简单选择排序). <br/>
 */
public class SimpleSelectionSort {


    public static void main(String[] args) {
        int[] arr = { 9, 1, 5, 8, 3, 7, 4, 6, 2 };
        System.out.println("排序之前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // 简单选择排序
        simpleSelectionSort(arr);

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void simpleSelectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            if (min != i) {
                swap(array, i, min);
            }
        }
    }

    static void swap(int[] array, int i, int min) {
        int temp = array[min];
        array[min] = array[i];
        array[i] = temp;
    }


}
