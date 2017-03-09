package my.javase.study.java8.funcInterface;

/**
 * Created by xpcomrade on 9/30/15.
 */
public class Main {
    public static void main(String[] args) {
        Defaultable defaultable = DefaulableFactory.create(DefaultableImpl::new);
        System.out.println(defaultable.defaultMethod());
    }
}
