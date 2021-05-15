package com.wong.thread;
//1.entend Thread 
public class TestThread1 extends Thread{
	 @Override
	//2. overide run() method
    public void run() {
	 for(int i=0; i<20; i++)
        System.out.println(Thread.currentThread().getName() + "run "+i);
    }

	public static void main(String[] args) {
		//3. use start() to start a thread
    	TestThread1 threadTest = new TestThread1();
        threadTest.start();
        
        for(int i=0; i<20; i++)
            System.out.println("main  "+i);

    }
}

