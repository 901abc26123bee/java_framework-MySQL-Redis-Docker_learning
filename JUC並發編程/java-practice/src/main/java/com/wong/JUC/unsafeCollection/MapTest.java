package com.wong.JUC.unsafeCollection;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
/*
 Map<String, String> map = new HashMap<>(); 
 	==> java.util.ConcurrentModificationException
 解决并发问题:
 1.Map<String,Object> map = Collections.synchronizedMap(new HashMap<>());
 2.Map<String, String> map = new ConcurrentHashMap<>();
*/
public class MapTest {
	public static void main(String[] args) {
		//map 是这样用的吗? 不是，工作中不用HashMap
        //默认等价于什么？new HashMap<>(16,0.75);
        //加载因子、初始化容量
		//Map<String,Object> map = new HashMap<>(16,0.75f);
		
        //解决并发问题
		//1. Map<String,Object> map = Collections.synchronizedMap(new HashMap<>());
		//2. Map<String, String> map = new ConcurrentHashMap<>();
		Map<String, String> map = new ConcurrentHashMap<>();
		for(int i=0; i<=30; i++) {
			new Thread(()->{
				map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
				System.out.println(map);
			}, String.valueOf(i)).start();
		}
	}
}
