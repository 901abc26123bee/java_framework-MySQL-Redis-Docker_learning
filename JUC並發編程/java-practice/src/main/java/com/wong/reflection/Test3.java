package com.wong.reflection;

public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class<?> c1=Class.forName("com.wong.reflection.User");
        Class<?> c2=Class.forName("com.wong.reflection.User");
        //打印hashcode可以看出一个类在内存中只有一个Class对象
        //一个类被被载后，类的整个结构都会被封装在Class对象中
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
    }
}
//实体类：pojo entity
class User{
	private String name;
	private int id;
	private int age;
	
	public User() {}
	
	public User(String name, int id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
