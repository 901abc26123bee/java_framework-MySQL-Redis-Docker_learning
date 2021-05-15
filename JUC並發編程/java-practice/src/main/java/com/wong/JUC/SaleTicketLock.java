package com.wong.JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 真正的多线程开发，公司中的开发，降低耦合性
 * 线程就是一个单独的资源类，没有任何附属的操作
 * 1.属性、方法
 */
public class SaleTicketLock {
	public static void main(String[] args) {
		 //并发，多线程操作同一资源类,把资源类丢入线程
        Ticket2 ticket = new Ticket2();
		new Thread(()->{
			for(int i=0; i<40; i++)
				ticket.sale();
		}, "a").start();
		
		new Thread(()->{
			for(int i=0; i<40; i++)
				ticket.sale();
		}, "b").start();
	
		new Thread(()->{
			for(int i=0; i<40; i++)
				ticket.sale();
		}, "c").start();

	}
}

//资源类 OOP
//lock三部曲
//1.new ReentrantLock();
//2.lock.lock();加锁
//3.finally=>lock.unlock();解锁
class Ticket2{
	private int ticketNum = 30;
	Lock lock = new ReentrantLock();
	public void sale() {
		lock.lock();
		//lock.tryLock();//嘗試獲取鎖
		try {
			if(ticketNum>0) {
				System.out.println(Thread.currentThread().getName() + "賣出了" +(ticketNum--) + "票，剩餘" + ticketNum);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}
}