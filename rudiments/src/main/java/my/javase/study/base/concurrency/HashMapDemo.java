package my.javase.study.base.concurrency;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

/**
 * Create by Jesse
 * Date：5:28:21 PM，Jul 22, 2014
 * Copyright (c) 2014，wangzhongping@ddmap.com All Rights Reserved. 
 * TODO：(这里用一句话描述这个类的作用). <br/> 
 */
public class HashMapDemo {
	@Test
	public void hashMapTest() throws Exception{
		final HashMap<String, String> map  = new HashMap<String, String>();
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 1000; i++){
					new Thread(new Runnable() {
						public void run() {
							map.put(UUID.randomUUID().toString(), "");
						}
					}, "thread-" + i).start();
				}
			}
		}, "main-thread");
		thread.start();
		thread.join();
		
		System.out.println(map.keySet().toArray().length);
		
	}
	
	@Test
	public void ConcurrentHashMapTest() throws Exception{
		final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 1000; i++){
					new Thread(new Runnable() {
						public void run() {
							map.put(UUID.randomUUID().toString(), "");
						}
					}, "thread-" + i).start();
				}
			}
		}, "main-thread");
		thread.start();
		thread.join();
		
		System.out.println(map.keySet().toArray().length);
	}
}
