package com.wong.JUC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁: 更加细粒度的控制
 * 独占锁(写锁) 一次只能由一个线程占有
 * 共享锁(读锁) 一次可以有多个线程占有
 * readWriteLock
 * 读-读 可以共存
 * 读-写  不能共存
 * 写-写 不能共存
 */
public class ReadWriteLockDemo {
	public static void main(String[] args) {
		MyCacheLock myCache = new MyCacheLock();
		
		for(int i=1; i<=5; i++) {
			final int temp = i;
			new Thread(()->{
				myCache.put(temp+"", temp+"");
			}, String.valueOf(i)).start();
		}
		
		for(int i=1; i<=5; i++) {
			final int temp = i;
			new Thread(()->{
				myCache.get(temp+"");
			}, String.valueOf(i)).start();
		}
	}
}
/**
 * 自定义缓存
 * 加锁的
 */
class MyCacheLock{
	private volatile Map<String, Object> map = new HashMap<String, Object>();
//	private Lock lock = new ReentrantLock();
	//读写锁: 更加细粒度的控制
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	//存，写入的时候，只希望同时只有一个线程写
	public void put(String key, Object value) {
//      lock.lock();
		readWriteLock.writeLock().lock();
		
		try {
			//业务代码
			System.out.println(Thread.currentThread().getName()+ " write in "+key);
			map.put(key,  value);
			System.out.println(Thread.currentThread().getName()+ " sucessfully write in ");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			readWriteLock.writeLock().unlock();
		}
		
	}
	//取，读，所有人都可以同时读！
	public void get(String key) {
		readWriteLock.readLock().lock();
		
		try {
			//业务代码
			System.out.println(Thread.currentThread().getName()+ " read "+key);
			Object o = map.get(key);
			System.out.println(Thread.currentThread().getName()+ " sucessfully readed ");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			readWriteLock.readLock().unlock();
		}
	}
}

class MyCache{
	private volatile Map<String, Object> map = new HashMap<String, Object>();
	//存，写
	public void put(String key, Object value) {
		System.out.println(Thread.currentThread().getName()+ " write in "+key);
		map.put(key,  value);
		System.out.println(Thread.currentThread().getName()+ " sucessfully write in ");
	}
	//取，读
	public void get(String key) {
		System.out.println(Thread.currentThread().getName()+ " read "+key);
		Object o = map.get(key);
		System.out.println(Thread.currentThread().getName()+ " sucessfully readed ");

	}
}