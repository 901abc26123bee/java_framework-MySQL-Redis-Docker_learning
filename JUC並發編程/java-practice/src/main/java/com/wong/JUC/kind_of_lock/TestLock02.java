package com.wong.JUC.kind_of_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
 Lock lock = new ReentrantLock();
 兩把鎖
 */
public class TestLock02 {
	public static void main(String[] args) {
		Phone2 phone2 = new Phone2();
		
		new Thread(()->{
		    //在调用 sms 的方法时已经为phone加上了一把锁
	        //而 call 方法由为其加上了一把锁
	        phone2.sms();
	    }, "A").start();
		
		new Thread(()->{
		    //在调用 sms 的方法时已经为phone加上了一把锁
	        //而 call 方法由为其加上了一把锁
	        phone2.sms();
	    }, "B").start();
	}
}

class Phone2{
	Lock lock = new ReentrantLock();
	
	//外門鎖
	public void sms() {
		lock.lock();// 兩把鎖
		// lock 鎖必須配對，否則會死鎖
		try {
			System.err.println(Thread.currentThread().getName()+" sms");
			call();//這裡也有鎖（內門鎖）
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}
	
	public void call() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+" call");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

