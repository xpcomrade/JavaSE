package my.study.java8.forkjoin;

import sun.misc.Unsafe;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by xpcomrade on 2017/4/12.
 * Copyright (c) 2017, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class Main {
    public static void main(String[] args) {
        List<RecursiveTask<TaskResult>> forks = new LinkedList<>();
        SiteBehaviorTask siteBehaviorTask1 = new SiteBehaviorTask();
        forks.add(siteBehaviorTask1);
       // siteBehaviorTask1.fork();
        SiteBehaviorTask siteBehaviorTask2 = new SiteBehaviorTask();
        forks.add(siteBehaviorTask2);
        //siteBehaviorTask2.fork();
        UserBaseInfoTask userBaseInfoTask1 = new UserBaseInfoTask();
        forks.add(userBaseInfoTask1);
        //userBaseInfoTask1.fork();


        ForkJoinPool fjPool = new ForkJoinPool(2);
        fjPool.invoke(siteBehaviorTask1);
        fjPool.invoke(siteBehaviorTask2);
        fjPool.invoke(userBaseInfoTask1);

        ArrayList<TaskResult> result = new ArrayList<>();
        for (RecursiveTask<TaskResult> task : forks) {
            result.add(task.join());
        }


        System.out.println(result.toString());

    }
}
