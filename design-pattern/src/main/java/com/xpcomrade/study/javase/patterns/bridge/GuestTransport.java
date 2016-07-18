package com.xpcomrade.study.javase.patterns.bridge;

/**
 * Created by xpcomrade on 02/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (客人运输). <br/>
 */
public class GuestTransport implements Transport {

    @Override
    public void transport() {
        System.out.print("运送客人");
    }
}
