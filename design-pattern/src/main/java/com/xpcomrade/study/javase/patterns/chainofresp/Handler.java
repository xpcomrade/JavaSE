package com.xpcomrade.study.javase.patterns.chainofresp;

/**
 * Created by xpcomrade on 01/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (抽象处理者角色Handler). <br/>
 */
public abstract class Handler {

    /**
     * 持有后继的责任对象
     */
    protected Handler successor;

    /**
     * 处理请求方法
     */
    public abstract void handlerRequest();

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
