package com.wong.java_basic;

public class static_test01 {
	public static void main(String[] args) {
		Student.go();
		
		Student student = new Student();
		student.run();
		student.go();
	}
}

class Student{
	private static int age;
	private double score;
	
	public void run() {
		System.out.println("run()");
	}
	
	public static void go() {
		System.out.println("go()");
	}
}