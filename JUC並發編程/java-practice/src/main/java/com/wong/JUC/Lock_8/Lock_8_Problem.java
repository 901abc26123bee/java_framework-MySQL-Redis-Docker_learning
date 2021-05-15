package com.wong.JUC.Lock_8;

import java.util.concurrent.TimeUnit;

//***** synchronized锁的对象是方法的调用者 ********
//8锁，就是关于锁的8个问题
//1.标准情况下，两个线程 先打印 发短信还是 打电话？ 1/发短信 2/打电话
//2.sendSms()方法延迟4秒，两个线程 先打印 发短信还是 打电话？ 1/发短信 2/打电话
public class Lock_8_Problem {
	public static void main(String[] args) {
		Phone phone = new Phone();
		//phone是先调用的，这个回答是错误的。
        //是因为，锁的存在
		new Thread(()->{phone.sendSms();},"A").start();
		//JUC休息
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(()->{phone.call();},"B").start();
	}
}
//资源类
class Phone{
	//synchronized 锁的对象是方法的调用者！
    //两个方法用的是同一个锁，谁先拿到谁执行！
	public synchronized void sendSms() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("send message");
	}
	public synchronized void call() {
		System.out.println("call");
	}
}