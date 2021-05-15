package com.wong.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//測試線程池
public class TestPool {
	public static void main(String[] args) {
		//create線程池
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		//執行
		service.execute(new MyThread());
		service.execute(new MyThread());
		service.execute(new MyThread());
		service.execute(new MyThread());
		
		//close connection
		service.shutdown();
	}	
}

class MyThread implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}
	
