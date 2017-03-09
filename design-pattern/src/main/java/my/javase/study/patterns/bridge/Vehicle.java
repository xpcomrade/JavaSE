package my.javase.study.patterns.bridge;

/**
 * Created by xpcomrade on 02/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (交通工具抽象类). <br/>
 */
public abstract class Vehicle {

    //持有运输接口实现
    private Transport transport;

    public void transport(){
        transport.transport();
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}
