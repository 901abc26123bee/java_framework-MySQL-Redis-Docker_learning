package com.wong.JUC.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
	//CAS   compareAndSet:比较并交换！
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(2020);
		//对于我们平时写的SQL：乐观锁！
		//public final boolean compareAndSet(int expect, int update) {
        //期望，更新
        //如果我期望的值达到了，那么就更新，否则就不更新，CAS是CPU的并发原语！
		//============捣乱的线程===========
		System.out.println(atomicInteger.compareAndSet(2020, 2021));
		System.out.println(atomicInteger.get());
		
		System.out.println(atomicInteger.compareAndSet(2021, 2020));
		System.out.println(atomicInteger.get());
		//============期望的线程============
		System.out.println(atomicInteger.compareAndSet(2020, 6666));
		System.out.println(atomicInteger.get());
		/*
		 * output:
		 	true
			2021
			true
			2020
			true
			2021
			==  problem	--> always true, but we want to be notified when the number was altered
			对于我们平时写的SQL：乐观锁！
		 */
	}
}
