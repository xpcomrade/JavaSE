package my.javase.study.patterns.strategy;

/**
 * Created by xpcomrade on 01/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (国际长途通话计费). <br/>
 */
public class InternationalCallStrategy implements Strategy {

    public Double callCharge(long time, CallTypeEnum callType) {
        return 2.0 * time;
    }
}
