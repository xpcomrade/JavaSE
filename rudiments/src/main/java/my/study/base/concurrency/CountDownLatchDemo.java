package my.study.base.concurrency;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.junit.Test;


/**
 * Create by Jesse
 * Date：9:23:02 PM，Jul 15, 2014
 * Copyright (c) 2014，wangzhongping@ddmap.com All Rights Reserved. 
 * TODO：(这里用一句话描述这个类的作用). <br/> 
 */
public class CountDownLatchDemo {
	
	@Test
	public void CountDownLatchThread() throws Exception{
		final CountDownLatch start = new CountDownLatch(1);
		int racer = 10; 
		final CountDownLatch end = new CountDownLatch(racer);
		final int circle = 50;
		
		for(int i = 0; i < racer; i++){
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						start.await();
						System.out.println(Thread.currentThread().getName() + " begin runing....");
						for(int j = 0; j < circle; j++){
							if (j % 3 == 0){
								System.out.println(Thread.currentThread().getName() + " begin runing....");
							}
						}
						System.out.println(Thread.currentThread().getName() + " finish runing....");
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						e.printStackTrace();
					} finally{
						end.countDown();
					}
				}
			});
			t.start();
		}
		
		System.out.println("车手准备中.......");
		long startTime = System.nanoTime();
		start.countDown();
		
		end.await();
		long endTime = System.nanoTime();
		
		System.out.println("比赛耗时:"+(endTime - startTime)+",现在准备开始颁奖啦。。。。。");
	}
	
	@Test
	public void CountDownLatchFutureTask() throws Exception{
		final CountDownLatch start = new CountDownLatch(1);
		int racer = 10; 
		final CountDownLatch end = new CountDownLatch(racer);
		final int circle = 50;
		
		FutureTask[] taskPool = new FutureTask[racer];
		
		for(int i = 0; i < racer; i++){
			FutureTask<Long> task = new FutureTask<Long>(new Callable<Long>() {
				@Override
				public Long call() throws Exception {
					long startTime = 0;
					long endTime = 0;
					try {
						start.await();
						startTime = System.currentTimeMillis();
						System.out.println(Thread.currentThread().getName() + " begin runing....");
						for(int j = 0; j < circle; j++){
							if (j % 3 == 0){
								System.out.println(Thread.currentThread().getName() + " begin runing....");
							}
						}
						System.out.println(Thread.currentThread().getName() + " finish runing....");
						endTime = System.currentTimeMillis();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						e.printStackTrace();
					} finally{
						end.countDown();
					}
					System.out.println(Thread.currentThread().getName() + "耗时" + (endTime - startTime));
					return (endTime - startTime);
				}
			});
			
			Thread t = new Thread(task);
			taskPool[i] = task;
			t.start();
		}
		
		System.out.println("车手准备中.......");
		long startTime = System.currentTimeMillis();
		start.countDown();
		
		end.await();
		long endTime = System.currentTimeMillis();
		
		System.out.println("比赛耗时:"+(endTime - startTime)+",现在准备开始颁奖啦。。。。。");
		
		HashMap<String, Long> map = new HashMap<String, Long>();
		for(int j = 0; j < taskPool.length; j++){
			Long time = (Long) taskPool[j].get();
			map.put(""+j, time);
		}
		System.out.println("得奖者耗时："+ Collections.min(map.values()));
	}
	
	@Test
	public void CountDownLatchCompletionService() throws Exception{
		
		int racer = 10; 
		final int circle = 50;
		
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch end = new CountDownLatch(racer);
		
		final ExecutorService executorService = Executors.newFixedThreadPool(racer);
		final CompletionService<Long> completionService = new ExecutorCompletionService<Long>(executorService);
		
		for (int i = 0; i < racer; i++){
			
			completionService.submit(new Callable<Long>() {
				@Override
				public Long call() throws Exception {
					long startTime = 0;
					long endTime = 0;
					try {
						start.await();
						startTime = System.currentTimeMillis();
						System.out.println(Thread.currentThread().getName() + " begin runing....");
						for(int j = 0; j < circle; j++){
							if (j % 3 == 0){
								System.out.println(Thread.currentThread().getName() + " begin runing....");
							}
						}
						System.out.println(Thread.currentThread().getName() + " finish runing....");
						endTime = System.currentTimeMillis();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						e.printStackTrace();
					} finally{
						end.countDown();
					}
					System.out.println(Thread.currentThread().getName() + "耗时" + (endTime - startTime));
					return (endTime - startTime);
				}
			});
		};
		
		System.out.println("车手准备中.......");
		long startTime = System.currentTimeMillis();
		start.countDown();
		
		end.await();
		long endTime = System.currentTimeMillis();
		
		System.out.println("比赛耗时:"+(endTime - startTime)+",现在准备开始颁奖啦。。。。。");
		
		HashMap<String, Long> map = new HashMap<String, Long>();
		for(int t = 0; t < racer; t++){
			try {
				Future<Long>  future = completionService.take();
				Long time = future.get();
				map.put(""+t, time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("得奖者耗时："+ Collections.min(map.values()));
	}
}
