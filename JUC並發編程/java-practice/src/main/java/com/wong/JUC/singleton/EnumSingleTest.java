package com.wong.JUC.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//enum 是一个什么？本身也是一个Class类
enum EnumSingle {
	INSTANCE;
	
	public EnumSingle getInstance() {
		return INSTANCE;
	}
}

class EnumSingleTest{
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		EnumSingle instance1 = EnumSingle.INSTANCE;
		//EnumSingle instance2 = EnumSingle.INSTANCE;
		
		//Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor();
		Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
		declaredConstructor.setAccessible(true);
		
		EnumSingle instance2 = declaredConstructor.newInstance();
		
		System.out.println(instance1);
		System.out.println(instance2);
		//System.out.println(instance1.equals(instance2));
		
		// EnumSingle.class.getDeclaredConstructor()   
		//		-->	java.lang.NoSuchMethodException: com.wong.JUC.singleton.EnumSingle.<init>()
		// EnumSingle.class.getDeclaredConstructor(String.class, int.class) 
		//		-->   java.lang.IllegalArgumentException: Cannot reflectively create enum objects
	}
}