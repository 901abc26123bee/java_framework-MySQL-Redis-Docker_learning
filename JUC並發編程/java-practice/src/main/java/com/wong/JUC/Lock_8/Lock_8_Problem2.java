package com.wong.JUC.Lock_8;

import java.util.concurrent.TimeUnit;
//3、增加了一个普通方法hello() ，是先执行 发短信 还是hello？ 
	//==>  1/hello  2/发短信   ==> 因为普通方法没有锁，不受锁的影响
//4、两个对象，两个同步方法，发短信还是 打电话？ 
	//==>  1/打电话   2/发短信   ==> 锁的是对象调用者，每个对象都有一把锁，这里是两个不同的对象，沒有延遲先行
public class Lock_8_Problem2 {
	public static void main(String[] args) {
		//两个对象，两个调用者，两个不同的对象，两把锁
		Phone2 phone1 = new Phone2();
		Phone2 phone2 = new Phone2();
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
class Phone2{
	//synchronized 锁的对象是方法的调用者！
    //两个方法用的是同一个锁，谁先拿到谁执行！
	public synchronized void sendSms() {
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("send message");
	}
	public synchronized void call() {
		System.out.println("call");
	}
	//这里没有锁！不是同步方法，不受锁的影响
	//普通方法没有锁(synchronized)，不受锁的影响
	public void hello() {
		System.out.println("say hello");
	}
}
