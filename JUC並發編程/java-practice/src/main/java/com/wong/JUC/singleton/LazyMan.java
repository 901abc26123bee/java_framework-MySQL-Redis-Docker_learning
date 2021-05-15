package com.wong.JUC.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


//单线程安全
public class LazyMan {
	//紅綠燈
	private static boolean can = false;
	
	//升級三重檢測
	private LazyMan() {
		/*
		//只能適用第一個線程默認用 getInstance() 取得 
		//		==>LazyMan instance = LazyMan.getInstance();
		synchronized (LazyMan.class){
            if(lazyMan != null){
                throw new RuntimeException("不要试图反射破坏异常");
            }

        }
        
        */
		synchronized (LazyMan.class){
            if(can==false){
                can = true;
            }else{
                throw new RuntimeException("不要试图反射破坏异常");
            }
            System.out.println(Thread.currentThread().getName()+"  ok");
        }
	}
	
	private volatile static LazyMan lazyMan;
	//双重检测锁模式的 懒汉式单例==>DCL懒汉式
	public static LazyMan getInstance() {
		//加鎖
		if(lazyMan == null) {
			synchronized (LazyMan.class) {
				if(lazyMan == null) {
					lazyMan = new LazyMan();//不是原子性操作

			        /**
			         * 由于对象创建不是原子性操作
			         * 1. 分配内存空间
			         * 2. 使用构造器创建对象
			         * 3. 将对象指向内存空间
			         */
			        /**
			         * 可能会发生指令重排
			         * 123
			         *
			         * 132	A
			         *	B		//此时LazyMan还没有构造
			         * 这是就需使用volatile关键字来防止指令重排
			         */
				}
			}
		}
		return lazyMan;
	}
	/*
	//多線程併發  ==> not safe, since the result is random
	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			new Thread(()->{
				LazyMan.getInstance();
			}).start();
		}
	}
	*/
	//反射破坏
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchFieldException, InvocationTargetException {
		//LazyMan instance = LazyMan.getInstance();
		
		Field cracker = LazyMan.class.getDeclaredField("can");
		cracker.setAccessible(true);
		
		Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor();//獲取空參構造器
		declaredConstructor.setAccessible(true);//無視私有構造器，可透過反射創建對象
		LazyMan instance2 = declaredConstructor.newInstance();//两个对象都用反射创建 ，那么还是会有问题 //用标志位解决这个问题
		
		cracker.set(instance2, false);//但是通过反射，强行改变标识符，还是会有问题
		
		LazyMan instance = declaredConstructor.newInstance();
		
		System.out.println(instance);
		System.out.println(instance2);
		/*
		 	main  ok
			main  ok
			com.wong.JUC.singleton.LazyMan@4dc63996
			com.wong.JUC.singleton.LazyMan@d716361
					===> not same ==> 非單例
		 * */
	}
}
