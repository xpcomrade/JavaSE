package my.javase.study.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by xpcomrade on 2017/3/9.
 * Copyright (c) 2017, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class TestCase {

    public static void main(String[] args) {
        // 被代理类的实例
        AbstractSubject realSubject = new RealSubject();
        // 获得被代理类的类加载器，使得JVM能够加载并找到被代理类的内部结构，以及已实现的interface
        ClassLoader loader = realSubject.getClass().getClassLoader();
        // 获得被代理类已实现的所有接口interface,使得动态代理类的实例
        Class<?>[] interfaces = realSubject.getClass().getInterfaces();

        // 用被代理类的实例创建动态代理类的实例，用于真正调用处理程序
        InvocationHandler handler = new DynamicProxy(realSubject);

        AbstractSubject proxy = (AbstractSubject)Proxy.newProxyInstance(loader, interfaces, handler);

        proxy.request();
    }
}
