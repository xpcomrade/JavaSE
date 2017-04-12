package my.study.base.concurrency;

import java.util.ArrayList;
import java.util.concurrent.Exchanger;

/**
 * Created by wangzp Date: 2:52:31 PM, Nov 15, 2013 Description:
 * Java并发 Exchanger 
 * Java并发Exchanger,两个线程可以交换对象的同步点。每个线程都在进入exchange(),方法时给出某个对象，并接受其他线程返回时给出的对象,主要特证描述如下：
 * 1. Exchanger用于在2个线程中交换对象。
 * 2.return_object = exchanger.exchange(exch_object)
 * 3.例子中Producer向ArrayList中缓慢填充随机整数，Consumer从另一个ArrayList中缓慢取出整数并输出。
 * 4.当Producer的ArrayList填满，并且Consumer的ArrayList为空时，2个线程才交换ArrayList。
 * 
 * 
 */
public class Exchanger_01 {

	public static void main(String[] args) throws Exception {
		Exchanger<ArrayList<Integer>> exchanger = new Exchanger<ArrayList<Integer>>();
		ArrayList<Integer> buffer1 = new ArrayList<Integer>(10);
		ArrayList<Integer> buffer2 = new ArrayList<Integer>(10);

		Thread pth = new ProducerThread(buffer1, exchanger);
		Thread cth = new ConsumerThread(buffer2, exchanger);

		pth.start();
		cth.start();

		Thread.sleep(60 * 1000);
		System.out.println("main: interrupting threads.");
		pth.interrupt();
		cth.interrupt();

		pth.join();
		cth.join();

		System.out.println("main: end.");
	}

}

class ProducerThread extends Thread {

	private ArrayList<Integer> buff;

	private Exchanger<ArrayList<Integer>> exchanger;

	public ProducerThread(ArrayList<Integer> buff,
			Exchanger<ArrayList<Integer>> exchanger) {
		this.buff = buff;
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try {
			while (true) {
				if (buff.size() >= 10) {
					// 与consumer交换buffer.
					System.out.println("producer: exchanging.");
					buff = exchanger.exchange(buff);
					buff.clear();
				}

				// 随机产生一个0-100的整数。
				int x = (int) (Math.random() * 100);
				buff.add(x);
				System.out.println("producer: " + x);

				// 随机等待0-3秒 。
				int t = (int) (Math.random() * 3);
				Thread.sleep(t * 1000);
			}
		} catch (InterruptedException e) {
			System.out.println("producer: interrupted.");
		}
	}
}

class ConsumerThread extends Thread {

	private ArrayList<Integer> buff;

	private Exchanger<ArrayList<Integer>> exchanger;

	public ConsumerThread(ArrayList<Integer> buff, Exchanger<ArrayList<Integer>> exchanger) {
		this.buff = buff;
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try {
			while (true) {
				for (Integer x : buff) {
					System.out.println("consumer: " + x);

					// 随机等待0-3秒 。
					int t = (int) (Math.random() * 3);
					Thread.sleep(t * 1000);
				}

				// 与producer交换buffer。
				System.out.println("consumer: exchanging.");
				buff = exchanger.exchange(buff);
			}
		} catch (InterruptedException e) {
			System.out.println("consumer: interrupted.");
		}
	}
}
