package my.javase.study.java8.funcInterface;

import java.util.function.Supplier;

/**
 * Java 8带来的另一个有趣的特性是接口可以声明（并且可以提供实现）静态方法
 * Created by xpcomrade on 9/30/15.
 */
public interface DefaulableFactory {

    // Interfaces now allow static methods
    static Defaultable create (Supplier<Defaultable> supplier) {
        return supplier.get();
    }
}
