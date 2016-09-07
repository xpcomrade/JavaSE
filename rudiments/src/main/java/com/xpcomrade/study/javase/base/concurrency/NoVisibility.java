package com.xpcomrade.study.javase.base.concurrency;
/** 
 * Created by wangzp
 * Date: 3:38:03 PM, Nov 11, 2013
 * Description: TODO(用一句话描述该文件做什么)
 */
public class NoVisibility {
	private static boolean ready;
	
	private static int number;
	
	private static class ReaderThread extends Thread{
		public void run(){
			while(!ready)
				Thread.yield();
			System.out.println(number);
		}
	}
	
	public static void main(String[] args) {
		new ReaderThread().start();
		number = 42;
		ready = true;
	}
}
