package com.xpcomrade.study.javase.patterns.chainofresp;

/**
 * Created by xpcomrade on 01/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class ConcreteHandler extends Handler {

    @Override
    public void handlerRequest() {
        if (getSuccessor() != null) {
            System.out.println("进行下一个请求");
            getSuccessor().handlerRequest();
        } else {
            System.out.println( "ConcreteHandler handled ");
            return;
        }

    }
}
