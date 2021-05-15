package com.wong.JUC.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列
 * 和其他的BlockingQueue 不一样， SynchronousQueue 不存储元素
 * put了一个元素，必须从里面先take取出来，否则不能再put进去值！
 * SynchronousQueue是一个内部只能包含一个元素的队列。
 * 插入元素到队列的线程被阻塞，直到另一个线程从队列中获取了队列中存储的元素。
 * 同样，如果线程尝试获取元素并且当前不存在任何元素，则该线程将被阻塞，直到线程将元素插入队列。
 */
public class SynchronousQueueDemo {
	public static void main(String[] args) {
		BlockingQueue<String> synchronousQueqe = new SynchronousQueue<>();
		
		new Thread(()->{
			try {
				System.out.println(Thread.currentThread().getName()+" put 1");
				synchronousQueqe.put("1");
				System.out.println(Thread.currentThread().getName()+" put 2");
				synchronousQueqe.put("2");
				System.out.println(Thread.currentThread().getName()+" put 3");
				synchronousQueqe.put("3");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		},"Thread 1").start();
		
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(3);
				System.out.println(Thread.currentThread().getName()+" take "+synchronousQueqe.take());
				TimeUnit.SECONDS.sleep(3);
				System.out.println(Thread.currentThread().getName()+" take "+synchronousQueqe.take());
				TimeUnit.SECONDS.sleep(3);
				System.out.println(Thread.currentThread().getName()+" take "+synchronousQueqe.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		},"Thread 2").start();
	}
}
