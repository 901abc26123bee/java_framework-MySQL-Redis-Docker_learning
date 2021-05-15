package com.wong.jvm;

public class StorageDemo {
	public static void main(String[] args) {
		//返回虛擬機試圖使用（分配）的最大內存
		long max = Runtime.getRuntime().maxMemory();
		//返回虛擬機 jvm 初始化總內存
		long total = Runtime.getRuntime().totalMemory();
		
		System.out.println("max = "+max+" 字節 \t" + (max/(double)1024/1024) + "MB");
		System.out.println("total = "+max+" 字節 \t" + (total/(double)1024/1024) + "MB");
		/*
		 * Console:
			max = 2147483648 字節 	2048.0MB
			total = 2147483648 字節 	130.0MB
		  Conclision:
		  默認情況下，分配的總內存 是電腦內存的 1/4  而初始化總內存 1/64
		  
			-Xms1024m -Xms1024m -XX:+PrintGCDetails  ====>  max
			-Xms8m -Xms8m -XX:+PrintGCDetails  ===> small
		 */
	}
}
