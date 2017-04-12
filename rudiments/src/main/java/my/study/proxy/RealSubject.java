package my.study.proxy;

/**
 * Created by xpcomrade on 2017/3/9.
 * Copyright (c) 2017, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class RealSubject implements AbstractSubject {

    @Override
    public void request() {
        System.out.println("RealSubject's request() ...");
    }
}
