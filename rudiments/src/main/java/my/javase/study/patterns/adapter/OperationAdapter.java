package my.javase.study.patterns.adapter;

/**
 * Created by xpcomrade on 2017/3/9.
 * Copyright (c) 2017, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class OperationAdapter implements ScoreOperation {

    private QuickSort sortObj; //定义适配者QuickSort对象

    private BinarySearch searchObj; //定义适配者BinarySearch对象

    public OperationAdapter() {
        sortObj = new QuickSort();
        searchObj = new BinarySearch();
    }

    @Override
    public int[] sort(int[] array) {
        return sortObj.quickSort(array);
    }

    @Override
    public int search(int[] array, int key) {
        return searchObj.binarySearch(array, key);
    }
}
