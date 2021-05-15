package com.wong.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadNew {
	public static void main(String[] args) {
		new MyThread1().start();
		
		new Thread(new MyThread2()).start();
		
		FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread3());
		new Thread(futureTask).start();
		
		try {
			Integer integer = futureTask.get();
			System.out.println(integer);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MyThread1 extends Thread{
	@Override
	public void run() {
		System.out.println("MyThread1");
	}
}

class MyThread2 implements Runnable{
	@Override
	public void run() {
		System.out.println("MyThread2");
	}
}

class MyThread3 implements Callable<Integer>{
	@Override
	public Integer call() throws Exception{
		System.out.println("MyThread3");
		return 100;
	}
}