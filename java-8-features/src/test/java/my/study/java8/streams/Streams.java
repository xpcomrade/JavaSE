package my.study.java8.streams;

import org.junit.Before;
import org.junit.Test;
import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by xpcomrade on 9/30/15.
 */
public class Streams {

    private enum Status {
        OPEN,CLOSED
    }

    private static final class  Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }

    private Collection<Task> tasks = null;
    @Before
    public void before() {
        tasks = Arrays.asList(
                new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 13),
                new Task(Status.CLOSED, 8)
        );
    }

    /**
     * 第一，task集合被转换化为其相应的stream表示。然后，filter操作过滤掉状态为CLOSED的task。
     * 下一步，mapToInt操作通过Task::getPoints这种方式调用每个task实例的getPoints方法把Task的stream转化为Integer的stream。
     * 最后，用sum函数把所有的分数加起来，得到最终的结果。
     */
    @Test
    public  void test1() {
        final long totalPointsOfOpenTasks = tasks
                .stream()
                .filter(task -> task.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();
        System.out.println("Total points: " + totalPointsOfOpenTasks);
    }

    /**
     * stream另一个有价值的地方是能够原生支持并行处理
     */
    @Test
    public void test2() {
        final long totalPoints = tasks
                .stream()
                .parallel()
                .map(task -> task.getPoints())
                .reduce(0, Integer::sum);

        System.out.println( "Total points (all tasks): " + totalPoints );
    }

    /**
     * 按照某种准则来对集合中的元素进行分组
     */
    @Test
    public void test3() {
        final Map<Status, List<Task>> map = tasks
                .stream()
                .collect(Collectors.groupingBy(Task::getStatus));

        System.out.println(map);
    }

    @Test
    public void test4() {
        final long totalPoints = tasks
                .stream()
                .parallel()
                .map(task -> task.getPoints())
                .reduce(0, Integer::sum);
        // Calculate the weight of each tasks (as percent of total points)
        final Collection<String> result = tasks
                .stream()                                        // Stream< String >
                .mapToInt(Task::getPoints)                     // IntStream
                .asLongStream()                                  // LongStream
                .mapToDouble(points -> points / totalPoints)   // DoubleStream
                .boxed()                                         // Stream< Double >
                .mapToLong(weigth -> (long) (weigth * 100)) // LongStream
                .mapToObj(percentage -> percentage + "%")      // Stream< String>
                .collect(Collectors.toList());                 // List< String >

        System.out.println(result);
    }
}
