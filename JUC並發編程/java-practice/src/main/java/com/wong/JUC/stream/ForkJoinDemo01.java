package com.wong.JUC.stream;

import java.util.concurrent.RecursiveTask;

/**
 * 求和计算的任务
 * 3000   6000(ForkJoin)   9000(Stream并行流)
 * 如何使用ForkJoin：
 * 1.forkJoinPool 通过它来执行
 * 2.计算任务 forkJoinPool.execute(ForkJoinTask<?> task)
 * 3.计算类要继承ForkJoinTask（RecursiveTask）
 */
@SuppressWarnings("serial")
public class ForkJoinDemo01 extends RecursiveTask<Long>{
	private Long start;
	private Long end;
	//临界值
	private Long temp = 10000L;
	
	public ForkJoinDemo01(Long start, Long end) {
		this.start = start;
		this.end = end;
	}
	
	//计算方法
	@Override
	protected Long compute() {
		if((end-start) < temp) {
			Long sum = 0L;
			for(Long i=start; i<=end; i++) {
				sum+=i;
			}
			return sum;
		}else { //ForkJoin  递归
			long middle = (start+end)/2;
			ForkJoinDemo01 task1 = new ForkJoinDemo01(start, middle);
			task1.fork(); 	//拆分任务，把任务压入线程队列
			ForkJoinDemo01 task2 = new ForkJoinDemo01(middle, end);
			task2.fork(); 	//拆分任务，把任务压入线程队列
			return task1.join() +task2.join();
		}
	}
}
