package my.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import static my.study.Printer.print;

/**
 * Created by xpcomrade on 2017/3/9.
 * Copyright (c) 2017, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class DynamicProxy  implements InvocationHandler {

    // 被代理类的实例
    Object obj;

    public DynamicProxy(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        print("start...");

        Object result = method.invoke(this.obj, args);

        print("end...");
        return result;
    }
}
