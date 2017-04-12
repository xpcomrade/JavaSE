package my.study.base.concurrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/** 
 * Created by wangzp
 * Date: 11:02:36 AM, Nov 15, 2013
 * Description: TODO(用一句话描述该文件做什么)
 */
public class Semaphore_01 {

	/**
	 * @param args
	 * @author wangzp
	 * @throws InterruptedException 
	 * @date 11:02:36 AM,Nov 15, 2013
	 */
	public static void main(String[] args){
		BoundHashSet<String> set = new BoundHashSet<String>(5);
		try {
			for (int i = 0; i < 5; i++) {
				set.add(new String("str" + i));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(set.getSize());
		
		try {
			set.add("str");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class BoundHashSet<T> {
	private final Set<T> set;
	private final Semaphore sem;
	
	/**
	 * @param bound
	 */
	public BoundHashSet(int bound) {
		this.set = Collections.synchronizedSet(new HashSet<T>());
		sem = new Semaphore(bound);
	}
	
	public boolean add (T o) throws InterruptedException {
		sem.acquire();
		boolean wasAdded = false;
		try {
			wasAdded = set.add(o);
			
			return wasAdded;
		} finally {
			if (!wasAdded) {
				sem.release();
			}
		}
	}
	
	public boolean remove (Object o) {
		boolean wasRemoved = set.remove(o);
		if (wasRemoved)
			sem.release();
		
		return wasRemoved;
	}
	
	public int getSize(){
		return this.set.size();
	}
}
