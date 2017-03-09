package my.javase.study.datastructure;

/**
 * Created by xpcomrade on 2016/7/12.
 * Copyright (c) 2016, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class Queue<T> {

    private int default_size = 10;

    private int capacity;

    private  Object[] elementData;

    private int index = 0;

    public Queue(){
        this.capacity = this.default_size;
        elementData = new Object[this.capacity];
    }

    public Queue(int initSize){
        this.capacity = initSize;
        elementData = new Object[capacity];
    }

    public void add(T element) {
        if (index > capacity -1 ) {
            throw new IndexOutOfBoundsException("the queue is full!");
        }
        elementData[index++] = element;
    }


}
