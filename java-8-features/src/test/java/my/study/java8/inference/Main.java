package my.study.java8.inference;

/**
 * Created by xpcomrade on 9/30/15.
 */
public class Main {
    public static void main(String[] args) {
        final TypeInference<String> value = new TypeInference<>();

        System.out.println(value.getOrDefault("22", TypeInference.defalutValue()));
    }

}
