package my.javase.study.base.concurrency;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/** 
 * Created by wangzp
 * Date: 10:23:02 AM, Nov 19, 2013
 * Description: TODO(用一句话描述该文件做什么)
 */
public class ConcurrentModificationException_01 {
	public static void main(String[] args) {
		//final HashSet<String> set = new HashSet<String>(Arrays.asList("a","b","c"));
		final Set<String> set = Collections.synchronizedSet(new HashSet<String>(Arrays.asList("a","b","c")));
		Thread t1 =  new Thread(new Runnable() {
			@Override
			public void run() {
				set.add("s");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 =  new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (String string : set) {
					System.out.println(string);
				}
			}
		});
		
		
		t2.start();
		t1.start();
	}
}
