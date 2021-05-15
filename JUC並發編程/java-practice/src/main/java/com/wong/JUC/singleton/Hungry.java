package com.wong.JUC.singleton;
/**
 * 饿汉式  单例模式
 * 構造器私有，別人無法 new 新的對象，保證內存中只有一個對象
 */
public class Hungry {
	//可能会浪费空间
	private byte[] data1 = new byte[1024*1024];
	private byte[] data2 = new byte[1024*1024];
	private byte[] data3 = new byte[1024*1024];
	private byte[] data4 = new byte[1024*1024];
	
	private Hungry() {}
	//直接加載唯一對象(new 內存中唯一一個對象)
	private final static Hungry HUNGRY = new Hungry();
	
	public static Hungry getInstance() {
		return HUNGRY;
	}
}
