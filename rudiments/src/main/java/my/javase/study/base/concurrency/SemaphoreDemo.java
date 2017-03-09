package my.javase.study.base.concurrency;


import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * Create by Jesse
 * Date：11:34:22 PM，Jul 15, 2014
 * Copyright (c) 2014，wangzhongping@ddmap.com All Rights Reserved. 
 * TODO：(semaphore 用来控制同时访问某个特定的资源的操作数量或者同时执行某个指定操作的数量). <br/> 
 */
public class SemaphoreDemo {
	
	@Test
	public void semaphoreTest(){
		final int SIZE = 2;
		final ResourcePool pool = new ResourcePool(SIZE);
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 10; i++){
			executor.execute(new Runnable() {
				@Override
				public void run() {
					String resource = null;  
	                try {  
	                    //取得resource  
	                    resource = pool.get();  
	                    //用resource做工作  
	                    System.out.println("I am working on " + resource);  
	                    Thread.sleep(500);  
	                    System.out.println("I finished on " + resource);  
	                } catch (InterruptedException ex) {  
	                	ex.printStackTrace();
	                }finally{
	                	
	                	if (resource != null){
	                		//归还resource  
	                		pool.release(resource);
	                	}
	                }  
				}
			});
		}
	}
	
	static class ResourcePool {
		
		Semaphore semaphore = null;
		
		ArrayList<String> resourcePool;
		
		Lock lock = new ReentrantLock();
		
		public ResourcePool(int size){
			resourcePool = new ArrayList<String>();
			for(int i = 0; i < size; i++){
				resourcePool.add("Resource-" + i);
			}
			semaphore = new Semaphore(size);
		}
		
		public String get() throws InterruptedException{
			System.out.println("try to get a resource...");
			if(semaphore.tryAcquire(10, TimeUnit.NANOSECONDS)){
				lock.lock();
				String resource = resourcePool.remove(0);
				lock.unlock();
				System.out.println("got a resource [" + resource + "]");
				return resource;
			} else {
				System.out.println("获取资源，等待超时....");
				
				throw new InterruptedException("获取资源，等待超时....");
			}
			
		}
		
		public void release(String resource){
			lock.lock();  
            System.out.println("[" + resource + "] have been returned...");  
            resourcePool.add(resource);  
            lock.unlock();  
		}
	}
}
