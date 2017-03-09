package my.javase.study.java8.funcInterface;

/**
 * Created by xpcomrade on 9/30/15.
 */
@FunctionalInterface
public interface Defaultable {

    void method();

    /**
     * Interfaces now allow default methods, the implementer may or may not implement (override) them.
     */
    default String defaultMethod(){
        return "";
    }
}
