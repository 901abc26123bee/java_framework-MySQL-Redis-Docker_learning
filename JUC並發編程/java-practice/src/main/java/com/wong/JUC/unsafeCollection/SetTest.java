package com.wong.JUC.unsafeCollection;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
/**
 * 同理可证：java.util.ConcurrentModificationException
 * 解决方案
 * 1、Set<String> set = Collections.synchronizedSet(new HashSet<>()); 工具类写法
 * 2、Set<String> set = new CopyOnWriteArraySet();  写入时复制 lock锁
 */
public class SetTest {
	public static void main(String[] args) {
		//Set<String> set = new HashSet<String>(); ==> java.util.ConcurrentModificationException
		//如何解决hashSet线程安全问题
        //1. Set<String> set = Collections.synchronizedSet(new HashSet<>());
		//2. Set<String> set = new CopyOnWriteArraySet<>();
        Set<String> set = new CopyOnWriteArraySet<>();
		for(int i=0; i<=20; i++) {
			new Thread(()->{
				set.add(UUID.randomUUID().toString().substring(0, 5));
				System.out.println(set);
			},String.valueOf(i)).start();
		}
	}
}
