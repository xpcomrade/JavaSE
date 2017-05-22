package my.study.java8;


import java.util.List;

/**
 * Created by xpcomrade on 2017/4/12.
 * Copyright (c) 2017, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class SiteBehaviorTask  extends FilterTask {

    private String taskType = "siteBehavior";

    private String codition = null;

    public SiteBehaviorTask (String codition) {
        this.codition = codition;
    }

    public SiteBehaviorTask () {

    }

    @Override
    protected TaskResult compute() {

        TaskResult<List> result = new TaskResult<List>();



        SiteBehaviorTask task1 = new SiteBehaviorTask();
        task1.fork();
        SiteBehaviorTask task2 = new SiteBehaviorTask();
        task2.fork();

        TaskResult r1 = task1.join();


        return result;
    }

}
