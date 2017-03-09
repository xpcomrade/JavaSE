package my.javase.study;

/**
 * Created by xpcomrade on 2017/2/26.
 * Copyright (c) 2017, xpcomrade@gmail.com All Rights Reserved.
 * Description: (打印). <br/>
 */
public class Printer {

    public static void print(String... cmds) {
        StringBuilder text = new StringBuilder("$ ");
        for (String cmd : cmds) {
            text.append(cmd).append(" ");
        }
        System.out.println(text.toString());
    }

    public static void print(Object result) {
        System.out.println(
                result instanceof byte[]
                        ? new String((byte[]) result)
                        : result);
    }

}
