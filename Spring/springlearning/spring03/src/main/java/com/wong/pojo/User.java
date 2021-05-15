package com.wong.pojo;

public class User {
   private String name;
   public User() {
       System.out.println("user無參構造方法");
  }
   public User(String name) {
	   this.name = name;
   }
   public void setName(String name) {
       this.name = name;
  }
   public void show(){
       System.out.println("name="+ name );
  }
}
