package my.javase.study.patterns.adapter;

/**
 * Created by xpcomrade on 02/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (适配器（Adapter）：通过包装一个需要适配的对象，把原接口转换成目标接口。　). <br/>
 */
public class Adapter2 implements Target {

    private Adaptee adaptee;

    public Adapter2 (Adaptee adaptee) {
        super();
        this.adaptee = adaptee;
    }

    @Override
    public void operate1() {
        adaptee.operate1();
    }

    @Override
    public void operate2() {
        System.out.println("operate2 ");
    }
}
