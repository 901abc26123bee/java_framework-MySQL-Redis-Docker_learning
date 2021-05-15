package com.wong.JUC.stream;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * 同一个任务，别人效率比你高几十倍
 */
public class ForkJoinTest01 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//test1();	//sum time : 8755
		//test2();	//sum time : 5272
		test3();	//sum time : 405
	}
	//普通程序员
	public static void test1() {
		Long sum = 0L;
		long start = System.currentTimeMillis();
		for(Long i=0L; i<10_0000_0000; i++) {
			sum+=i;
		}
		long end = System.currentTimeMillis();
		System.out.println("sum time : "+(end-start));
	}
	//会使用ForkJoin
	public static void test2() throws InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinDemo01(0L, 10_0000_0000L);
		ForkJoinTask<Long> submit = forkJoinPool.submit(task);
//      forkJoinPool.execute();//執行任務，無結果，同步，會阻塞
//      forkJoinPool.submit();//提交任務，有結果，异步
		Long sum = submit.get();//會阻塞
		long end = System.currentTimeMillis();
		System.out.println("sum time : "+(end-start));
	}
	//Stream并行流
	public static void test3() {
		long start = System.currentTimeMillis();
		//Stream并行流 () (]
        //rangeClosed包含最后的结束节点，range不包含。
		long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
		long end = System.currentTimeMillis();
		System.out.println("sum time : "+(end-start));
	}
}
