package my.study.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static my.study.Printer.print;
/**
 * Created by xpcomrade on 2017/3/9.
 * Copyright (c) 2017, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class TestCase {

    @Test
    public void base() throws Exception {

        Constructor constructor = MyClass.class.getDeclaredConstructor(int.class); //获取构造方法
        constructor.setAccessible(true);

        MyClass myClassReflect = (MyClass) constructor.newInstance(10); //创建对象

        Method method = MyClass.class.getDeclaredMethod("increase", int.class); //获取方法
        method.invoke(myClassReflect, 5); //调用方法

        Field field = MyClass.class.getDeclaredField("count"); //获取域
        field.setAccessible(true);

        print("Reflect -> ",  field.getInt(myClassReflect)+"");
    }


    @Test
    public void demo1(){
        MyClass myClass = new MyClass(0);

        print(
                "package name: ",
                myClass.getClass().getPackage().getName(),
                ", class name: ",
                myClass.getClass().getName()
        );
    }

    @Test
    public void demo2() throws Exception {
        Class<?> c1 = null;
        Class<?> c2 = null;

        c1 = Class.forName("MyClass");
        print("package name: ",  c1.getPackage().getName(), "class name: " , c1.getName());

        c2 = MyClass.class;
        print("package name: ",  c2.getPackage().getName(), "class name: " , c2.getName());

        print("c1 == c2 ? ", Boolean.toString(c1 == c2));
    }

    @Test
    public void demo3() throws Exception {
        Class<?> c1 = null;
        c1 = Class.forName("MyClass");

        MyClass myClass = (MyClass)c1.newInstance();
        myClass.increase(2);

        print("count :", myClass.getCount()+"");

    }


    @Test
    public void demo4() throws Exception {
        Class<?> c1 = Class.forName("MyClass");
        Constructor<?>[] constructors = c1.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            print("ParameterCount :", constructor.getParameterCount()+"", "ParameterTypes：");
            for (Class<?> cla : constructor.getParameterTypes()) {
                System.out.print(cla.getName());
            }
        }

    }

    @Test
    public void demo5() throws Exception{
        Class<?> class1 = null;
        class1 = Class.forName("MyClass");

        //取得父类名称
        Class<?>  superClass = class1.getSuperclass();
        print("SuperMan类的父类名: ", superClass.getName());

        print("===============================================");


        Field[] fields = class1.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            print("类中的成员: " , fields[i]+"");
        }
        print("===============================================");


        //取得类方法
        Method[] methods = class1.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            print("取得SuperMan类的方法：");
            print("函数名：", methods[i].getName());
            print("函数返回类型：" , methods[i].getReturnType()+"");
            print("函数访问修饰符：", Modifier.toString(methods[i].getModifiers()));
            print("函数代码写法： " , methods[i]+"");
        }

        print("===============================================");

        //取得类实现的接口,因为接口类也属于Class,所以得到接口中的方法也是一样的方法得到哈
        Class<?> interfaces[] = class1.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            print("实现的接口类名: ", interfaces[i].getName());
        }
    }

    @Test
    public void demo6() throws Exception {
        Class class1 = Class.forName("MyClass");
        String nameString = class1.getClassLoader().getClass().getName();

        print("类加载器类名: ", nameString);
    }


}
