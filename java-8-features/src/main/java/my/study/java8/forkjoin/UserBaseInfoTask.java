package my.study.java8.forkjoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

/**
 * Created by xpcomrade on 2017/4/12.
 * Copyright (c) 2017, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class UserBaseInfoTask  extends RecursiveTask<TaskResult> {

    @Override
    protected TaskResult compute() {
        return new TaskResult("site", Arrays.asList(4,5,6));
    }
}
