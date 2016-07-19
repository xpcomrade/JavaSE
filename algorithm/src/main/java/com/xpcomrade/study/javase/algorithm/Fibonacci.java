package com.xpcomrade.study.javase.algorithm;

/**
 * Created by xpcomrade on 2016/7/19.
 * Copyright (c) 2016, xpcomrade@gmail.com All Rights Reserved.
 * Description: (斐波那契). <br/>
 */
public class Fibonacci {

    public static void main(String[] args) {
        int n = 50;
        System.out.println(fibonacci(n));
        System.out.println(fibonacciRecursion(n));
    }

    /**
     * 采用递归方法获取第n个斐波那契数
     * @param n
     * @return 返回第n个斐波纳契数
     */
    static long fibonacciRecursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
        }
    }

    static long fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        long num1 = 1, fibonacci = 1,temp = 0;
        for (int i = 2; i < n; i++) {
            temp = fibonacci;
            fibonacci += num1;
            num1 = temp;
        }
        return fibonacci;
    }
}
