package com.xpcomrade.study.javase.patterns.chainofresp;

/**
 * Created by xpcomrade on 01/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (单元测试). <br/>
 */
public class TestCase {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setSuccessor(handler2);
        handler1.handlerRequest();
    }
}
