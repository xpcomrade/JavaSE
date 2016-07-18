package com.xpcomrade.study.javase.patterns.adapter;

/**
 * Created by xpcomrade on 02/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (适配器（Adapter）：通过包装一个需要适配的对象，把原接口转换成目标接口。　). <br/>
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void operate2() {
        System.out.println("operate2 ..");
    }
}
