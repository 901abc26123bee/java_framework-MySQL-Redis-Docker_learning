package com.wong.java_basic;

public class static_test02 {
	public static void main(String[] args) {
		Person p1 = new Person();
		System.out.println("=================");
		Person p2 = new Person();
	}
}

class Person{
	//2.賦初值
	{
		System.out.println("匿名代碼塊");
	}
	//1.只執行一次
	static {
		System.out.println("靜態代碼塊");
	}
	//3.
	public Person() {
		System.out.println("構造方法");
	}
}