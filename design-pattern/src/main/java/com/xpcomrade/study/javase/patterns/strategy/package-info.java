/**
 * Created by xpcomrade on 01/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: ( Java设计模式之策略模式). <br/>
 */
package com.xpcomrade.study.javase.patterns.strategy;

/**
 Java设计模式之策略模式

 优点
 1、可以动态的改变对象的行为

 缺点
 1、客户端必须知道所有的策略类，并自行决定使用哪一个策略类
 2、策略模式将造成产生很多策略类

 组成
 环境类(Context):用一个Strategy对象来配置，维护一个对Strategy对象的引用。
 抽象策略类(Strategy):定义所有支持的算法的公共接口。 Context使用这个接口来调用某个策略实现类的的算法。
 具体策略类 (如LocalCallStrategy):以Strategy接口实现某具体算法。
 策略工厂类 (StrategyFactory) : 根据一个类型返回对应算法的具体实现类
 */