package my.javase.study.patterns.strategy;

/**
 * Created by xpcomrade on 01/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (环境类). <br/>
 */
public class Context {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public Double callCharge(long time,  Integer type){
        strategy = StrategyFactory.getInstance().creator(type);

        return strategy.callCharge(time, CallTypeEnum.valueOf(type));
    }
}
