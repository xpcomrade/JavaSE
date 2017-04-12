package my.study.java8.inference;

/**
 * Created by xpcomrade on 9/30/15.
 */
public class TypeInference<T> {
    public static<T> T defalutValue() {
        return null;
    }

    public T getOrDefault(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }
}
