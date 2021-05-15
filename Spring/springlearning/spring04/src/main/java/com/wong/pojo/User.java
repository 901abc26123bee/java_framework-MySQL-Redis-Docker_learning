package com.wong.pojo;
// 注意：這裡沒有有參構造器！
public class User {
	
    private String name;
	private int age;

	public User() {}

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
    
    public void setName(String name) {
        this.name = name;
   }

    public void setAge(int age) {
        this.age = age;
   }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
   }
}
