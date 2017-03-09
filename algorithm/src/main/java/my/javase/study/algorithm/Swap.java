package my.javase.study.algorithm;

/**
 * Created by xpcomrade on 2016/9/7.
 * Copyright (c) 2016, xpcomrade@gmail.com All Rights Reserved.
 * Description: (变量值交换). <br/>
 */
public class Swap {


    public static void main(String[] args) {
        swap(4,10);
    }

    static void swap(int a, int b) {
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println("a:" + a + ",b:" + b);
    }
}
