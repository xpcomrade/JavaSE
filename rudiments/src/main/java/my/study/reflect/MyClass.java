package my.study.reflect;

/**
 * Created by xpcomrade on 2017/3/9.
 * Copyright (c) 2017, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class MyClass {

    private int count;

    public MyClass(){

    }

    public MyClass(int start) {
        this.count = start;
    }


    public void increase(int step) {
        this.count = this.count + step;
    }

    public int getCount(){
        return this.count;
    }
}
