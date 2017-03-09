package my.javase.study.base.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/** 
 * Created by wangzp
 * Date: 4:41:41 PM, Nov 15, 2013
 * Description: TODO(用一句话描述该文件做什么)
 */
public class FutureTask_02 {

}

class Memoizer<A, V> implements Computable<A, V>{
	
	private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
	
	private final Computable<A, V> c;
	
	public Memoizer(Computable<A, V> c){
		this.c = c;
	}
	
	@Override
	public V compute(final A arg) throws InterruptedException {
		while(true){
			Future<V> f = cache.get(arg);
			if (f == null){
				Callable<V> eval = new Callable<V>() {
					@Override
					public V call() throws Exception {
						return c.compute(arg);
					} 
				};
				
				FutureTask<V> ft = new FutureTask<V>(eval);
				f = cache.putIfAbsent(arg, ft);
				if (f == null) {
					f = ft;
					ft.run();
				}
				
				try {
					return f.get();
				}catch (CancellationException e) {
					cache.remove(arg, f);
				}catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}

interface Computable<A, V> {
	V compute(A arg) throws InterruptedException;
}
