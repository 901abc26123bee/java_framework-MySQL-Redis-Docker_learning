package com.wong.JUC.Often_Use_Class;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 * 集齐77个龙珠召唤神龙
 */
// 召唤龙珠的线程
public class CyclicBarrierDemo {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(7, ()->{
			System.out.println("召唤神龙成功!");
		});
		for(int i=1; i<=7; i++) {
			//通過 final 變量, 讓 new Thread 拿到 i 值(new Thread only can get final value)
			final int temp = i;
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"收集" + temp + "个龙珠");
				try {
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}).start();
		}
	}
}
