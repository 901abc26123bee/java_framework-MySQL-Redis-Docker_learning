package com.wong.JUC.kind_of_lock;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {
	public static void main(String[] args) {
        String lockA="lockA";
        String lockB="lockB";

        //两个线程拿两个互斥资源，他们首先拿到了是不同的，后请求自己所没有的
        new Thread(new MyThread(lockA,lockB),"T1").start();
        new Thread(new MyThread(lockB,lockA),"T2").start();
    }
}
class MyThread implements Runnable{
	//定义两个资源
    private String lockA;
    private String lockB;

    public MyThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"  lock:"+lockA+" ,want to get --> "+lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"  lock:"+lockB+" ,want to get --> "+lockA);
            }
        }
    }
}
