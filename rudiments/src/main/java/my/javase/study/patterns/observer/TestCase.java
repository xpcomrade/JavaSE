package my.javase.study.patterns.observer;

import org.junit.Test;

/**
 * Created by xpcomrade on 03/12/2015.
 * Copyright (c) 2015, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class TestCase {

    public static void main(String[] args) {
        MyTopic mytopic = new MyTopic();

        Observer observer1 = new MyTopicSubcriber("observer1");
        Observer observer2 = new MyTopicSubcriber("observer2");
        Observer observer3 = new MyTopicSubcriber("observer3");

        //attach observer to subject
        observer1.setSubject(mytopic);
        observer2.setSubject(mytopic);
        observer3.setSubject(mytopic);

        //register observers to the subject
        mytopic.register(observer1);
        mytopic.register(observer2);
        mytopic.register(observer3);

        observer1.handler();
        observer2.handler();
        observer3.handler();
        //send message to subject
        mytopic.postMessage("test");
    }
}
