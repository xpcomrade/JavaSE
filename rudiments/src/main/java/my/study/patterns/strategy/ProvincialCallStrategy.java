package my.study.patterns.strategy;

/**
 * Created by xpcomrade on 01/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (省际通话计费). <br/>
 */
public class ProvincialCallStrategy implements Strategy {

    public Double callCharge(long time, CallTypeEnum callType) {
        return 0.2 * time;
    }
}
