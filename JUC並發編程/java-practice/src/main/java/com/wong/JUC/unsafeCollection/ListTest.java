package com.wong.JUC.unsafeCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

//java.util.ConcurrentModificationException 并发修改异常
public class ListTest {
	public static void main(String[] args) {
		//并发下ArrayList是不安全的
        /**
         * 解决方案
         * 1、List<String> list = new Vector<>(); 源码有synchronized解决的
         * 2、List<String> list = Collections.synchronizedList(new ArrayList<>()); Collections工具类解决
         * 3、List<String> list = new CopyOnWriteArrayList();   transient volatile关键字
         */
		//List<String> list = new Vector<>();
		//List<String> list = Collections.synchronizedList(new ArrayList<>());

        //CopyOnWrite写入时复制  COW 计算机程序设计领域的一种优化策略;
        //多个线程调用的时候，list，读取的时候，固定的，写入的(覆盖)
		//寫入時先複製一個數組出來，寫完再插回去，保證數據安全
        //在写入的时候避免覆盖，造成数据问题！
        //读写分离 MyCat
        //CopyOnWriteArrayList 比 Vector 好在哪里？ ==> 前者是lock锁，后则是 synchronized（效率較低）锁
		 		
		//List<String> list = new ArrayList<>();
		// List<String> list = new Vector<>();
		//List<String> list = Collections.synchronizedList(new ArrayList<>());
		List<String> list = new CopyOnWriteArrayList();
		
		for(int i=0; i<=10; i++) {
			new Thread(()->{
				list.add(UUID.randomUUID().toString().substring(0, 5));
				System.out.println(list);
			}, String.valueOf(i)).start();
		}
	}
}
