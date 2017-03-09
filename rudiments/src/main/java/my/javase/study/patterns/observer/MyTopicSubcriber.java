package my.javase.study.patterns.observer;

/**
 * Created by xpcomrade on 03/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class MyTopicSubcriber implements Observer {

    private String name;
    private Subject topic;

    public MyTopicSubcriber(String name) {
        this.name = name;
    }

    @Override
    public void setSubject(Subject subject) {
        this.topic = subject;
    }

    @Override
    public void handler() {
        String msg = (String)topic.getUpdateInfo();

        if (msg == null) {
            System.out.println( name + ":: No new message");
        } else {
            System.out.println(name + ":: Consuming message::" + msg);
        }
    }
}
