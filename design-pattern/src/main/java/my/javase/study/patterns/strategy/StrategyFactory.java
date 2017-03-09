package my.javase.study.patterns.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xpcomrade on 01/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (策略工厂). <br/>
 */
public final class StrategyFactory {

    private static StrategyFactory factory = new StrategyFactory();

    private StrategyFactory(){

    }

    private static Map<Integer, Strategy> enumMap = new HashMap<Integer, Strategy>();
    static {
        enumMap.put(CallTypeEnum.LOCAL_CALL.type(), new LocalCallStrategy());
        enumMap.put(CallTypeEnum.PROVINCIAL_CALL.type(), new ProvincialCallStrategy());
        enumMap.put(CallTypeEnum.INTERNATIONAL_CALL.type(), new InternationalCallStrategy());
    }

    public Strategy creator(Integer type) {
        return enumMap.get(type);
    }

    public static StrategyFactory getInstance() {
        return factory;
    }


}
