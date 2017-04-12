package my.study.patterns.observer;


/**
 * Created by xpcomrade on 03/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public interface Subject {

    /**
     * method to register observer
     * @param observer
     */
    public void register(Observer observer);


    /**
     * method to unregister observer
     * @param observer
     */
    public void unregister(Observer observer);


    /**
     * method to notify observers of change
     */
    public void notifyObservers();

    /**
     * method to get updates
     * @return
     */
    public Object getUpdateInfo();

}
