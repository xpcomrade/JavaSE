package my.javase.study.base.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * Created by wangzp
 * Date: 5:51:56 PM, Nov 14, 2013
 * Description: TODO(当所有玩家都通过关卡1，才能进入关卡2)
 */
public class CyclicBarrier_01 {
	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(4, new GameBarrier());
		ExecutorService executor = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 4; i++) {
			executor.submit(new Player(cb,i));
		}
		executor.shutdown();
	}
}

class Player implements Runnable{
	
	private CyclicBarrier cyclicBarrier;
	
	private int id;
	
	public Player(CyclicBarrier cyclicBarrier, int id){
		this.cyclicBarrier = cyclicBarrier;
		this.id = id;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("玩家" + id + "正在玩第一关.....");
			cyclicBarrier.await();
			System.out.println("玩家" + id + "进入第二关.....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

class GameBarrier implements Runnable {
	@Override
	public void run() {
			System.err.println("所有玩家进入第二关.....");
	}
}
