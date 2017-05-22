package my.study.java8;

import java.io.Serializable;

/**
 * Created by xpcomrade on 2017/4/13.
 * Copyright (c) 2017, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class TaskResult<V> implements Serializable {


    private String taskType;

    private V result;

    public TaskResult() {
    }

    public TaskResult(String taskType, V result) {
        this.taskType = taskType;
        this.result = result;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public V getResult() {
        return result;
    }

    public void setResult(V result) {
        this.result = result;
    }
}
