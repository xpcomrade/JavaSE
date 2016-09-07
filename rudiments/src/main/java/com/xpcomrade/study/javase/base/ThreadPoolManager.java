package com.xpcomrade.study.javase.base;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** 
 * Created by wangzp
 * Date: 6:04:54 PM, Oct 30, 2013
 * Description: 一个发送消息模块，将消息发送到消息队列中。无需等待返回结果，发送模块继续执行其他任务。
 * 消息队列中的指令有线程池中的线程来处理。使用一个Queue来存放线程池溢出的任务
 */
public class ThreadPoolManager {
	private static ThreadPoolManager tpm = new ThreadPoolManager(); 
	// 线程池维护线程的最少数量 
	private final static int CORE_POOL_SIZE = 4; 
	// 线程池维护线程的最大数量 
	private final static int MAX_POOL_SIZE = 10; 
	// 线程池维护线程所允许的空闲时间 
	private final static int KEEP_ALIVE_TIME = 0; 
	// 线程池所使用的缓冲队列大小 
	private final static int WORK_QUEUE_SIZE = 10; 
	// 消息缓冲队列 
	Queue<String> msgQueue = new LinkedList<String>(); 
	
	public static ThreadPoolManager newInstance(){ 
		return tpm; 
	}
	
	private ThreadPoolManager(){}
	
	final Runnable accessBufferThread  = new Runnable() {
		@Override
		public void run() {
			if (hasMoreAcquire()) {
				String msg = msgQueue.poll();
				Runnable task = new AccessDBThread(msg); 
				threadPool.execute(task); 
			}
		}
	};
	
	private boolean hasMoreAcquire() { 
		return !msgQueue.isEmpty();
	}
	
	public void addLogMsg(String msg) {
		Runnable task = new AccessDBThread(msg);
		threadPool.execute(task);
	}
	
	final RejectedExecutionHandler handler = new RejectedExecutionHandler() {
		
		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			System.out.println(((AccessDBThread) r).getMsg()+"消息放入队列中重新等待执行"); 
			msgQueue.offer(((AccessDBThread) r).getMsg()); 			
		}
	};
	
	
	// 管理数据库访问的线程池 
	final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, 
			new ArrayBlockingQueue(WORK_QUEUE_SIZE), this.handler);
	
	// 调度线程池 
	final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1); 
	
	final ScheduledFuture taskHandler = scheduler.scheduleAtFixedRate(accessBufferThread, 0, 1, TimeUnit.SECONDS ); 
}
