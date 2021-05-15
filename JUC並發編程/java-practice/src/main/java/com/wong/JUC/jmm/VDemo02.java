package com.wong.JUC.jmm;

import java.util.concurrent.atomic.AtomicInteger;

//测试 volatile 不保证原子性
/* Solution:
 * 1.synchronized 保證只有一個線程加解鎖
*/
public class VDemo02 {
	//volatile不保证原子性
	//private volatile static int num = 0;
	
	//原子类的 Integer，解决原子性问题
	// AtomicInteger 调用的是底层的 CAS
	private volatile static AtomicInteger num = new AtomicInteger(0);
	
	public static void add() {
		//num++;//不是一个原子性操作
		num.getAndIncrement();//AtomicInteger +1方法 ,CAS,比synchronized高效多倍
	}
	
	public static void main(String[] args) {//main线程
		//理论上 num结果应该为20000
		for(int i=0; i<20; i++) {
			new Thread(()->{
				for(int j=0; j<1000; j++) {
					add();
				}
			}).start();
		}
		//Thread.activeCount()当前存活的线程数
		while(Thread.activeCount()>2) {// java 默認執行 main 、 gc
			Thread.yield();//yield将当前线程变为就绪状态
		}
		System.out.println(Thread.currentThread().getName()+"  "+num);//main  19623
	}
}
