package com.wong.mybatis.pojo;

public class User {
	
    private int id;  //id
    private String name;   //姓名
    private String password;   //密码，和 MySQL 中表名不一
    
    
	public User() {}
	
	public User(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return password;
	}
	public void setPwd(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
}