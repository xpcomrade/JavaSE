package my.javase.study.patterns.observer;

/**
 * Created by xpcomrade on 03/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: (观察者). <br/>
 */
public interface Observer {

    /**
     * attach with subject to observer
     * @param subject
     */
    public void setSubject(Subject subject);

    /**
     * method to update the observer
     */
    public void handler();

}
