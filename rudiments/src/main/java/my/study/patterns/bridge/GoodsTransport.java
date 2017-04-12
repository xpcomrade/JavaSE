package my.study.patterns.bridge;

/**
 * Created by xpcomrade on 02/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (货物运输). <br/>
 */
public class GoodsTransport implements Transport {

    @Override
    public void transport() {
        System.out.print("运输货物");
    }
}
