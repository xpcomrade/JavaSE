package my.javase.study.java8.funcInterface;

/**
 * Created by xpcomrade on 9/30/15.
 */
public class DefaultableImpl implements Defaultable {

    @Override
    public void method() {

    }

    @Override
    public String defaultMethod() {
        return "Overridden implementation";
    }
}
