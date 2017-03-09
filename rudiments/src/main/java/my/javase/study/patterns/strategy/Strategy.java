package my.javase.study.patterns.strategy;

/**
 * Created by xpcomrade on 01/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (抽象策略类). <br/>
 */
public interface Strategy {

    public Double callCharge(long time, CallTypeEnum callType);
}
