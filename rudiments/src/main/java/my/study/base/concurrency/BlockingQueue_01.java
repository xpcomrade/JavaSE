package my.study.base.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;


/** 
 * Created by wangzp
 * Date: 5:05:27 PM, Nov 12, 2013
 * Description: TODO(用一句话描述该文件做什么)
 */
public class BlockingQueue_01 {
	
	public static void main(String[] args) throws Exception {
		//BlockingQueue<String> drop  = new ArrayBlockingQueue<String>(5, true);
		BlockingQueue<String> drop  = new SynchronousQueue<String>();
		new Thread(new Producer(drop)).start();
		new Thread(new Consumer(drop)).start();
		
	}
}

class Producer implements Runnable{
	
	private BlockingQueue<String> drop;

	List<String> message = Arrays.asList("Mares eat oats", "Does eat oats",
			"Little lambs eat ivy", "Wouldn't you eat ivy too?");

	
	public Producer (BlockingQueue<String> drop){
		this.drop = drop;
	}
	
	@Override
	public void run() {
		try {
			for(String str : this.message){
				drop.put(str);
				System.out.println("put :" + str);
			}
			drop.put("DONE");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable{
	private BlockingQueue<String> drop;
	
	public Consumer (BlockingQueue<String> drop){
		this.drop = drop;
	}

	@Override
	public void run() {
		try {
			String msg = null;
			while (!((msg = drop.take()).equals("DONE")))
				System.out.println("take:" + msg);
			
		} catch (InterruptedException intEx) {
			System.out.println("Interrupted! "
					+ "Last one out, turn out the lights!");
		}
	}
}
