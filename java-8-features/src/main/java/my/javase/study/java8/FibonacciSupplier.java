package my.javase.study.java8;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by xpcomrade on 2016/11/1.
 * Copyright (c) 2016, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class FibonacciSupplier implements Supplier<Long> {

    long a = 0, b = 1;

    @Override
    public Long get() {
        long x = a + b;
        a = b;
        b = x;
        return a;
    }

    public static void main(String[] args) {
        Stream<Long> fibonacci = Stream.generate(new FibonacciSupplier());

        fibonacci.limit(10).forEach(System.out::println);
    }
}
