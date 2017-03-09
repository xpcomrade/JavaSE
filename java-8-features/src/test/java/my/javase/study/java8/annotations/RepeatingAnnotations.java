package my.javase.study.java8.annotations;

import java.lang.annotation.*;

/**
 * Created by xpcomrade on 9/30/15.
 */
public class RepeatingAnnotations {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter {
        String value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        Filter[] value();
    }

    @Filter("filter1")
    @Filter("filter2")
    public interface Filterable {
    }

    public static void main (String[] args) {
        for (Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
            System.out.println(filter.value());
        }
    }
}
