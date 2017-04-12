package my.study.base.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/** 
 * Created by wangzp
 * Date: 1:55:16 PM, Nov 15, 2013
 * Description: TODO(用一句话描述该文件做什么)
 */
public class FutureTask_01 {
	public static void main(String[] args) {
		try {
			Preloader test = new Preloader();
			test.start();
			ProductInfo info = test.get();
			System.out.println(info.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}

class ProductInfo {
	
	private int pid;
	private String pname;
	
	public ProductInfo(int pid, String pname){
		this.pid = pid;
		this.pname = pname;
	}
	
	public static ProductInfo loadProductInfo(){
		return new ProductInfo(1, "test");
	}

	@Override
	public String toString() {
		return "ProductInfo [pid=" + pid + ", pname=" + pname + "]";
	}
	
}

class Preloader {
	
	private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
		@Override
		public ProductInfo call() throws Exception {
			return ProductInfo.loadProductInfo();
		}
	});
	
	private final Thread thread = new Thread(future);
	
	public void start(){
		thread.start();
	}
	
	public ProductInfo get() throws InterruptedException, ExecutionException {
		return future.get();
	}
}