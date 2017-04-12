package my.study.patterns.adapter;

/**
 * Created by xpcomrade on 2017/3/9.
 * Copyright (c) 2017, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public interface ScoreOperation {

    int[] sort (int[] array);

    int search(int[] array, int key);
}
