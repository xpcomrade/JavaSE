package com.xpcomrade.study.javase.patterns.adapter;

import org.junit.Test;

/**
 * Created by xpcomrade on 02/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class TestCase {

    @Test
    public void adapter() {
        Target target = new Adapter();
        target.operate1();
        target.operate2();

    }

    @Test
    public void adapter2() {
        Target target = new Adapter2(new Adaptee());
        target.operate1();
        target.operate2();
    }
}
