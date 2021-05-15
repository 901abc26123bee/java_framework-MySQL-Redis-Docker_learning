package com.wong.JUC.Lock_8;

import java.util.concurrent.TimeUnit;

//7、1个静态的同步方法，1个普通的同步方法，一个对象， 先发短信 还是打电话？  1/打电话  2/发短信
//7、1个静态的同步方法，1个普通的同步方法，两个对象， 先发短信 还是打电话？  1/打电话  2/发短信
public class Lock_8_Problem4 {
	public static void main(String[] args) {
		//两个对象的Class类模板只有一个，static，锁的是class
		Phone4 phone1 = new Phone4();
		Phone4 phone2 = new Phone4();
		
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
class Phone4{
	//synchronized 锁的对象是方法的调用者！
    //static 静态方法
    //类一加载就有了！锁的是Class模板
	
	//静态的同步方法，锁的是 Class类 模板
	public static synchronized void sendSms() {
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("send message");
	}
	
	//普通的同步方法,锁的调用者
	public synchronized void call() {
		System.out.println("call");
	}
}
