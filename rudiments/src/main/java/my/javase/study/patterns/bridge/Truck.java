package my.javase.study.patterns.bridge;

/**
 * Created by xpcomrade on 02/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (大卡车). <br/>
 */
public class Truck extends  Vehicle {

    @Override
    public void transport() {
        System.out.print("卡车");
        super.transport();
    }
}
