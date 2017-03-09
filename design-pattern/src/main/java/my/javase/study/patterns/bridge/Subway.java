package my.javase.study.patterns.bridge;

/**
 * Created by xpcomrade on 02/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (地铁). <br/>
 */
public class Subway extends Vehicle {

    @Override
    public void transport() {
        System.out.print("地铁");
        super.transport();
    }
}
