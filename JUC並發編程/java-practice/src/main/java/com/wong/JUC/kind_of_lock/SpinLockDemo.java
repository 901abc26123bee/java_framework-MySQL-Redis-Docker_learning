package com.wong.JUC.kind_of_lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {
	AtomicReference<Thread> atomicReference = new AtomicReference<>();
	//加鎖
    public void myLock(){
        Thread thread = Thread.currentThread();

        System.out.println(thread.getName() + "=======>Lock");

        //自旋锁
        //由两个线程操作
        //第一个直接获取成功不需要自旋
        //第二个由于thread不为null所以会自旋
        //if it is what we except==null, then put a thread and run
        while(!atomicReference.compareAndSet(null, thread)){

        }
    }

    //解鎖
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "=====> unLock");
        //if it is what we except=thread, then turn it to null==unlock
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) throws InterruptedException {

        SpinLockDemo lock = new SpinLockDemo();

        new Thread(()->{
            lock.myLock();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }

        }).start();


        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            lock.myLock();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }

        }).start();
    }
}
