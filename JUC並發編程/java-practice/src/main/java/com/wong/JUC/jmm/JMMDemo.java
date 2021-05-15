package com.wong.JUC.jmm;

import java.util.concurrent.TimeUnit;

public class JMMDemo {
	//不加volatile 程序就会死循环 ==== > 问题: 程序不知道主内存中的值已经被修改过了
    //加上volatile 可以保证可见性
	private volatile static int number = 0; 
	
	public static void main(String[] args) {
		new Thread(()->{
			while(number == 0) {
				
			}
		}).start();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		
		number = 1;
		System.out.println(number);
	}
}
