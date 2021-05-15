package com.wong.jvm;

public class Test01 {
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		
		System.out.println(car1.hashCode());
		System.out.println(car2.hashCode());
		System.out.println(car3.hashCode());
		//225534817
		//1878246837
		//929338653
		
		Class<? extends Car> aClass1= car1.getClass();
		Class<? extends Car> aClass2= car2.getClass();
		Class<? extends Car> aClass3= car3.getClass();
		
		System.out.println(aClass1.hashCode());
		System.out.println(aClass2.hashCode());
		System.out.println(aClass3.hashCode());
		//1304836502
		//1304836502
		//1304836502

		
		ClassLoader classLoader = aClass1.getClassLoader();
		
		System.out.println(classLoader);
		System.out.println(classLoader.getParent());
		System.out.println(classLoader.getParent().getParent());
		//jdk.internal.loader.ClassLoaders$AppClassLoader@55054057
		//jdk.internal.loader.ClassLoaders$PlatformClassLoader@4b1210ee		\jre\lib\ext
		//null -->	1.not exist   2.cannot get it	-rt.jar
	}
}

class Car{
	
}