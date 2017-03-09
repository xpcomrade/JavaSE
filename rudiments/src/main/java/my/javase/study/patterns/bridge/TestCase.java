package my.javase.study.patterns.bridge;

import org.junit.Test;

/**
 * Created by xpcomrade on 01/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (单元测试). <br/>
 */
public class TestCase {

    @Test
    public void subway(){
        Subway subway = new Subway();
        subway.setTransport(new GuestTransport());
        subway.transport();
    }

    @Test
    public void truck(){
        Truck truck = new Truck();
        truck.setTransport(new GoodsTransport());
        truck.transport();
    }

}
