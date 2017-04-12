package my.study.java8.optional;

import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by xpcomrade on 10/26/15.
 */
public class Main {

    @Test
    public void testOfNUllable() {
        /**
         *  ofNullable为指定的值创建一个Optional，如果指定的值为null，则返回一个空的Optional。
            ofNullable与of方法相似，唯一的区别是可以接受参数为null的情况
         */
        Optional<String> fullName = Optional.ofNullable(null);
        //isPresent()返回true，否则返回false
        System.out.println("Full Name is set? " + fullName.isPresent());
        //为了防止Optional为空值，orElseGet()方法通过回调函数来产生一个默认值
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
        //map()函数对当前Optional的值进行转化，然后返回一个新的Optional实例。orElse()方法和orElseGet()方法类似，但是orElse接受一个默认值而不是一个回调函数。
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
    }

    @Test
    public void testOf() {
        /**
         * of为非null的值创建一个Optional。of方法通过工厂方法创建Optional类。
         * 需要注意的是，创建对象时传入的参数不能为null。如果传入参数为null，则抛出NullPointerException
         */
        Optional<String> fullName = Optional.of("Tom");
        //isPresent()返回true，否则返回false
        System.out.println("Full Name is set? " + fullName.isPresent());
        //为了防止Optional为空值，orElseGet()方法通过回调函数来产生一个默认值
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[null]"));
        //map()函数对当前Optional的值进行转化，然后返回一个新的Optional实例。orElse()方法和orElseGet()方法类似，但是orElse接受一个默认值而不是一个回调函数。
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
    }

    /**
     * ifPresent方法接受lambda表达式参数,如果Optional值不为空，lambda表达式会处理并在其上执行操作。
     */
    @Test
    public void testIsPresent(){
        Optional<String> name = Optional.of("Tom");
        name.ifPresent((value) -> {
            System.out.println("The length of the value is: " + value.length());
        });
    }

    /**
     * orElseThrow如果有值则将其返回，否则抛出supplier接口创建的异常。
     */
    @Test
    public void testOrElseThrow() {
        Optional<String> empty = Optional.ofNullable(null);
        try {
            empty.orElseThrow(ValueAbsentException::new);
        } catch (ValueAbsentException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /**
     *  如果有值，则对其执行调用mapping函数得到返回值。
        如果返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional
     */
    @Test
    public void testMap(){
        Optional<String> name = Optional.ofNullable(null);
        //map方法执行传入的lambda表达式参数对Optional实例的值进行修改。
        //为lambda表达式的返回值创建新的Optional实例作为map方法的返回值。
        Optional<String> upperName = name.map((String value) -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found"));
    }

    /**
     * 如果有值，为其执行mapping函数返回Optional类型返回值，否则返回空Optional。
     * flatMap与map（Funtion）方法类似，区别在于flatMap中的mapper返回值必须是Optional。
     * 调用结束时，flatMap不会对结果用Optional封装
     */
    @Test
    public void testFlatMap(){
        Optional<String> name = Optional.ofNullable("xpcomrade");
        //flatMap与map（Function）非常类似，区别在于传入方法的lambda表达式的返回类型。
        //map方法中的lambda表达式返回值可以是任意类型，在map函数返回之前会包装为Optional。
        //但flatMap方法中的lambda表达式返回值必须是Optionl实例。
        Optional<String> upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found"));
    }

    /**
     * filter个方法通过传入限定条件对Optional实例的值进行过滤
     * 如果有值并且满足断言条件返回包含该值的Optional，否则返回空Optional。
     */
    @Test
    public void testFilter() {
        Stream<String> names = Stream.of("Lamurudu", "Okanbi", "Oduduwa");
        Optional<String> _name = names
                .filter(name -> name.startsWith("L"))
                .findFirst();

        //filter方法检查给定的Option值是否满足某些条件。如果满足则返回同一个Option实例，否则返回空Optional。
        Optional<String> longName = _name.filter((value) -> value.length() > 6);
        System.out.println(longName.orElse("The name is less than 6 characters"));
    }


}
