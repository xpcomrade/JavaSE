package my.study.java8.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by xpcomrade on 10/27/15.
 */
public class CountTask extends RecursiveTask {

    private static final int THRESHOLD = 2;

    private int start;

    private int end;

    public CountTask (int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Object compute() {
        int sum = 0;

        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (start + end) / THRESHOLD;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);

            leftTask.fork();
            rightTask.fork();
            sum = (int)leftTask.join() + (int)rightTask.join();
        }

        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1,20);
        Future result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
