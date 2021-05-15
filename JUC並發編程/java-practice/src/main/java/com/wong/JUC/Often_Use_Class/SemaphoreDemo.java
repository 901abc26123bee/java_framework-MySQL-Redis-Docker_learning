package com.wong.JUC.Often_Use_Class;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


public class SemaphoreDemo {
	public static void main(String[] args) {
		//线程数量：停车位！限流！
		Semaphore semaphore = new Semaphore(3);
		
		for(int i=1; i<=6; i++) {
			new Thread(()->{
				//acquire()都会阻塞
				try {
					semaphore.acquire();// 得到
					System.out.println(Thread.currentThread().getName()+"抢到车位");
					TimeUnit.MICROSECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开车位");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					semaphore.release(); //release() 释放
				}
			}, String.valueOf(i)).start();;
		}
	}
}
