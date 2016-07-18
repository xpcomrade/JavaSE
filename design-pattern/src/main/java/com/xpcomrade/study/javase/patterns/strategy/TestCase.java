package com.xpcomrade.study.javase.patterns.strategy;

import org.junit.Test;

/**
 * Created by xpcomrade on 01/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (单元测试). <br/>
 */
public class TestCase {

    @Test
    public void LocalCallStrategy(){
        Context context = new Context();
        Double money = context.callCharge(100, CallTypeEnum.LOCAL_CALL.type());
        System.out.println("本地通话计费：" + money + '元');
    }

    @Test
    public void provincialCallStrategy(){
        Context context = new Context();
        Double money = context.callCharge(100, CallTypeEnum.PROVINCIAL_CALL.type());
        System.out.println("国内长途通话计费：" + money + '元');
    }

    @Test
    public void internationalCallStrategy(){
        Context context = new Context();
        Double money = context.callCharge(100, CallTypeEnum.INTERNATIONAL_CALL.type());
        System.out.println("国际长途通话计费：" + money + '元');
    }


}
