package com.wong.thread;

public class TestThread3 implements Runnable{
	@Override
    public void run() {
        for (int i = 0; i < 00; i++) {
            System.out.println("TestThread " + i);
        }
    }

    public static void main(String[] args) {
        //main线程
        TestThread3 t3 = new TestThread3();
        //创建线程对象,通过线程对象来开启线程,代理模式
        new Thread(t3).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("mainThread " + i);
        }
    }
}
