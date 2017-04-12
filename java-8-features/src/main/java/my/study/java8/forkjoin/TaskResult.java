package my.study.java8.forkjoin;

import java.io.Serializable;

/**
 * Created by xpcomrade on 2017/4/12.
 * Copyright (c) 2017, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class TaskResult implements Serializable {

    private String taskType;

    private Object result;

    public TaskResult() {
    }

    public TaskResult(String taskType, Object result) {
        this.taskType = taskType;
        this.result = result;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TaskResult{" +
                "taskType='" + taskType + '\'' +
                ", result=" + result +
                '}';
    }
}
