package com.xpcomrade.study.javase.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xpcomrade on 03/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class MyTopic implements Subject {

    private List<Observer> observers;
    private volatile boolean changed;
    private String message;

    public MyTopic(){
        this.observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer observer) {
        if (observer == null)
            throw new NullPointerException("Null Observer");

        synchronized (observers) {
            if(!observers.contains(observer)){
                observers.add(observer);
            }
        }

    }

    @Override
    public void unregister(Observer observer) {
        synchronized (observers) {
            observers.remove(observer);
        }

    }

    @Override
    public void notifyObservers() {
        if (changed) {
            this.changed = false;
            for (Observer observer : observers) {
                observer.handler();
            }
        }
    }

    @Override
    public Object getUpdateInfo() {
        return this.message;
    }

    /**
     * mthod to post message to the topic
     * @param msg
     */
    public void postMessage (String msg) {
        System.out.println("Message Posted to Topic :" + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }
}
