package my.javase.study.java8.parameter;


import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by xpcomrade on 9/30/15.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Method method = Main.class.getMethod("main", String[].class);
        for (final Parameter parameter : method.getParameters()){
            System.out.println("Parameter：" + parameter.getName());
        }
    }

}
