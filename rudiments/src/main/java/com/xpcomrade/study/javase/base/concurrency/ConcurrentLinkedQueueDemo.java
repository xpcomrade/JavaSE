package com.xpcomrade.study.javase.base.concurrency;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.Test;

/**
 * Create by Jesse
 * Date：10:58:58 PM，Jul 23, 2014
 * Copyright (c) 2014，wangzhongping@ddmap.com All Rights Reserved. 
 * TODO：(这里用一句话描述这个类的作用). <br/> 
 */
public class ConcurrentLinkedQueueDemo {
	
	@Test
	public void ConcurrentLinkedQueueTest(){
		ConcurrentLinkedQueue<String> linkedQueue = new ConcurrentLinkedQueue<String>();
		linkedQueue.offer("Str1");
		linkedQueue.add("Str2");
	}
}	
