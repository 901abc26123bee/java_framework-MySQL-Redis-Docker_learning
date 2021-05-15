package com.wong.JUC.kind_of_lock;

/**
 * synchronized	就一耙鎖
 */
public class TestLock {
	public static void main(String[] args) {
		Phone phone = new Phone();
		
		new Thread(()->{
		    //在调用 sms 的方法时已经为phone加上了一把锁
	        //而 call 方法由为其加上了一把锁
	        phone.sms();
	    }, "A").start();

		new Thread(()->{
		    //在调用 sms 的方法时已经为phone加上了一把锁
	        //而 call 方法由为其加上了一把锁
	        phone.sms();
	    }, "B").start();
	}
}

class Phone{
	//synchronized	就一耙鎖
	//外門鎖
	public synchronized void sms() {
		System.err.println(Thread.currentThread().getName()+" sms");
		call();//這裡也有鎖（內門鎖）
	}
	
	public synchronized void call() {
		System.out.println(Thread.currentThread().getName()+" call");
	}
}
