package my.javase.study.java8.aprallel;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * Created by xpcomrade on 10/27/15.
 */
public class Main {

    @Test
    public void parallelArrays () {
        long[] arryOfLong = new long[20000];

        Arrays.parallelSetAll(arryOfLong, index -> ThreadLocalRandom.current().nextInt(1000000));

        Arrays.stream(arryOfLong).limit(10).forEach(
                i -> System.out.print(i + " ")
        );
        System.out.println();

        Arrays.parallelSort(arryOfLong);
        Arrays.stream(arryOfLong).limit(10).forEach(
                i -> System.out.print(i + " ")
        );
        System.out.println();

    }

    @Test
    public void test () {
        long a = IntStream.range(0, 100).mapToLong(x -> {
            for (int i = 0; i < 100_000_000; i++) {
                System.out.println("X:" + i);
            }
            return x;
        }).sum();
    }
}
