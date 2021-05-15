package com.wong.JUC.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/*
 **注意点：**
Integer使用了对象缓存机制，默认范围是-128~127，
推荐使用静态工厂方法 valueOf获取对象实例，而不是new，
因为valueOf使用缓存，而new 一定会创建新的对象分配新的内存空间；
 */
public class CASDemo02 {
	public static void main(String[] args) {
		//AtomicStampedReference 注意，如果泛型是一个包装类(Integer)，注意对象的引用问题
        //Integer使用了对象缓存机制，默认范围是-128~127，推荐使用静态工厂方法 valueOf获取对象实例，而不是new，因为valueOf使用缓存，而new 一定会创建新的对象分配新的内存空间
        //正常在业务操作，这里比较的都是一个个对象
		AtomicStampedReference<Integer> atomicReference = new AtomicStampedReference<>(1,1);
        new Thread(()->{
        	int stamp = atomicReference.getStamp();
            System.out.println("a1==>"+stamp);//获得版本号
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // always get the newest version
            System.out.println(Thread.currentThread().getName()+" "+atomicReference.compareAndSet(1, 5,
                    atomicReference.getStamp(), atomicReference.getStamp() + 1));

            System.out.println("a2 stamp ==>"+atomicReference.getStamp());

            System.out.println(Thread.currentThread().getName()+" "+atomicReference.compareAndSet(5, 1,
                    atomicReference.getStamp(), atomicReference.getStamp() + 1));
            System.out.println("a3 stamp ==>"+atomicReference.getStamp());
        },"A").start();

        //乐观锁原理相同！
        new Thread(()->{
            int stamp = atomicReference.getStamp();
            System.out.println("b1 stamp ==>"+stamp);//获得版本号
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" "+atomicReference.compareAndSet(1, 5,
                    stamp, stamp + 1));
            System.out.println("b2 stamp ==>"+atomicReference.getStamp());
        },"B").start();
	}
}
