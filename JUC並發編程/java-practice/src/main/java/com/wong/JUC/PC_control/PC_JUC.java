package com.wong.JUC.PC_control;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PC_JUC {
	public static void main(String[] args) {
		Data2 data = new Data2();
		
		new Thread(()->{
			for(int i=0; i<10; i++) {
				try {
					data.increment();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "a").start();
		
		new Thread(()->{
			for(int i=0; i<10; i++) {
				try {
					data.decrement();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "b").start();
		
		//**问题存在：A,B,C,D或者两个以上的线程就会存在问题！虚假唤醒**
		/*
		 	if判断改为while判断
			因为if只会执行一次，执行完会接着向下执行if（）外边的
			***而while不会，直到条件满足才会向下执行while（）外边的*** 
		 */
		new Thread(()->{
			for(int i=0; i<10; i++) {
				try {
					data.increment();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "c").start();
		
		new Thread(()->{
			for(int i=0; i<10; i++) {
				try {
					data.decrement();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "d").start();
	}
}

//判斷是否需要等待，業務，通知
//数字，资源类
class Data2{
	private int number = 0;
	
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	//condition.await();//等待
	//condition.signalAll();//唤醒全部
	
	//+1
	public void increment() throws InterruptedException {
		lock.lock();
		try {
			//业务代码
			//判斷是否需要等待
			while(number!=0){
		        //等待
				condition.await();//
		    }
		    number++;
		    System.out.println(Thread.currentThread().getName()+"==>"+number);
		    //通知其他线程，我+1完毕了
		    condition.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	//-1
	public void decrement() throws InterruptedException {
		lock.lock();
		try {
			//业务代码
			//判斷是否需要等待
			while(number==0){
		        //等待
				condition.await();//
		    }
		    number--;
		    System.out.println(Thread.currentThread().getName()+"==>"+number);
		    //通知其他线程，我-1完毕了
		    condition.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}