package com.wong.JUC.Pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//Executors不安全，所以要自定义new ThreadPoolExecutor
//自定义线程池
//new ThreadPoolExecutor.AbortPolicy()); //队列满了，还有人进来，不处理这个人的，抛出异常
//new ThreadPoolExecutor.DiscardPolicy()); //队列满了，还有人进来，不处理这个人的，不会抛出异常
//new ThreadPoolExecutor.DiscardOldestPolicy()); //队列满了，尝试去和最早的竞争，不会抛出异常
//new ThreadPoolExecutor.CallerRunsPolicy()); //队列满了，哪来的去哪里！打发  这里是main线程去处理 ==> main ok 
public class ExecutorsDemo02 {
	public static void main(String[] args) {
		//- corePoolSize：核心线程池大小
        //- maximumPoolSize：最大核心线程池大小
        //- keepAliveTime：最大线程池的大小,超时了没有人调用就会释放
        //- unit：超时单位
        //- workQueue：阻塞队列,等候区满了，使用最大线程池
        //- threadFactory：线程工程，创建线程的，一般不用动
        //- handler：拒绝策略
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		ExecutorService threadPool = new ThreadPoolExecutor(
				2, 
				Runtime.getRuntime().availableProcessors(), 
				3, 
				TimeUnit.SECONDS, 
				new LinkedBlockingDeque<Runnable>(3),//候客區
				Executors.defaultThreadFactory(),
				new ThreadPoolExecutor.DiscardOldestPolicy());//队列满了，尝试去和最早的线程竞争，不会抛出异常

		try {
			//最大承载：Queue + max
			//超过 RejectedExecutionException
			for(int i=0; i<10; i++) {
				//使用了线程池之后，要使用线程池来创建线程
				threadPool.execute(()->{
					System.out.println(Thread.currentThread().getName()+" ok ");
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//线程池用完，程序结束，关闭线程池
			threadPool.shutdown();
		}
	}
}
