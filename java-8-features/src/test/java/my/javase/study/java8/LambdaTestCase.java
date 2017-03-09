package my.javase.study.java8;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.SequenceInputStream;
import java.util.Arrays;

/**
 * LambdaTestCase
 * Created by xpcomrade on 9/30/15.
 */
public class LambdaTestCase {

    /**
     * 一个lambda可以由用逗号分隔的参数列表、–>符号与函数体三部分表示
     */
    @Test
    public void lambdaTest1() {
        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));
    }

    /**
     * 请注意参数e的类型是由编译器推测出来的。同时，你也可以通过把参数类型与参数包括在括号中的形式直接给出参数的类型
     */
    @Test
    public void lambdaTest2() {
        Arrays.asList("a", "b", "c").forEach((String e) -> System.out.println(e));
    }

    /**
     * 在某些情况下lambda的函数体会更加复杂，这时可以把函数体放到在一对花括号中，就像在Java中定义普通函数一样
     */
    @Test
    public void lambdaTest3() {
        String separator = ",";
        Arrays.asList("a", "b", "c").forEach((String e) -> {
            System.out.println(e + separator);
        });
    }

    @Test
    public void lambdaTest4() {
        Arrays.asList("a", "b", "c").sort((e1, e2) -> e1.compareTo(e2));
    }

    @Test
    public void lambdaTest5(){
        Arrays.asList("a", "b", "c").sort((e1, e2) -> {
            int result = e1.compareTo(e2);
            System.out.println(result);
            return result;
        });
    }
}
