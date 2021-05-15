package com.wong.JUC.Lock_8;

import java.util.concurrent.TimeUnit;
//5.增加两个静态的同步方法，只有一个对象，发短信还是 打电话？   1/发短信   2/打电话
//6.两个对象！增加两个静态的同步方法，只有一个对象，发短信还是 打电话？   1/发短信   2/打电
public class Lock_8_Problem3 {
	public static void main(String[] args) {
		//两个对象的Class类模板只有一个，static，锁的是class
		Phone3 phone1 = new Phone3();
		Phone3 phone2 = new Phone3();
		
		//phone是先调用的，这个回答是错误的。
        //是因为，锁的存在
		new Thread(()->{phone1.sendSms();},"A").start();
		//JUC休息
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(()->{phone2.call();},"B").start();
	}
}
//资源类
//Phone3唯一的一个 class对象
class Phone3{
	//synchronized 锁的对象是方法的调用者！
    //static 静态方法
    //类一加载就有了！锁的是Class模板
	public static synchronized void sendSms() {
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("send message");
	}
	public static synchronized void call() {
		System.out.println("call");
	}
}
