package com.wong.mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wong.mybatis.pojo.User;
import com.wong.mybatis.utils.MybatisUtils;


public class UserMapperTest {
	 @Test
	 public void getUserList() {
	       SqlSession session = MybatisUtils.getSession();
	       //方法一:
	       //List<User> users = session.selectList("com.kuang.mapper.UserMapper.selectUser");
	       //方法二:
	       UserMapper mapper = session.getMapper(UserMapper.class);
	       List<User> users = mapper.getUserList();

	       for (User user: users){
	           System.out.println(user);
	       }
	       
	       session.close();//donnot forget

	  }
	 
	 @Test
	 public void getUserById() {
		 SqlSession session = MybatisUtils.getSession();
		 
		 //UserMaper mapper = new UserMapperImpl();
		 UserMapper mapper = session.getMapper(UserMapper.class);
		 User user = mapper.getUserById(1);
		 System.out.println(user);
		 
		 session.close();//donnot forget
	 }

	 //增刪改需要提交事務（要碼全部成功，否則失敗）
	 @Test
	 public void addUser() {
		 SqlSession session = MybatisUtils.getSession();
		 
		 UserMapper mapper = session.getMapper(UserMapper.class);
		 int res = mapper.addUser(new User(6, "haha", "09876"));
		 if(res>0)
			 System.out.println("successly insert");
		 //提交事務
		 session.commit();//提交事务,重点!不写的话不会提交到数据库
		 session.close();//donnot forget
	 }
	//增刪改需要提交事務（要碼全部成功，否則失敗）
	 @Test
	 public void addUser2() {
		 SqlSession session = MybatisUtils.getSession();
		 
		 UserMapper mapper = session.getMapper(UserMapper.class);
		 Map<String, Object> map = new HashMap<>();
		 map.put("userid", 8);
		 map.put("username", "hello");
		 map.put("userpwd", "86875");
		 
		 mapper.addUser2(map);
		 session.close();//donnot forget
	 }
	//增刪改需要提交事務（要碼全部成功，否則失敗）
	 @Test
	 public void updateUser() {
		 SqlSession session = MybatisUtils.getSession();
		 
		 UserMapper mapper = session.getMapper(UserMapper.class);
		 mapper.updateUser(new User(4,"lala", "58809"));
		 //提交事務
		 session.commit();//提交事务,重点!不写的话不会提交到数据库
		 session.close();//donnot forget
	 }
	//增刪改需要提交事務（要碼全部成功，否則失敗）
	 @Test
	 public void deleteUser() {
	    SqlSession session = MybatisUtils.getSession();
	    UserMapper mapper = session.getMapper(UserMapper.class);
	    int i = mapper.deleteUser(5);
	    System.out.println(i);
	    session.commit(); //提交事务,重点!不写的话不会提交到数据库
	    session.close();//donnot forget
	 }
	 @Test
	 public void getUserLike() {
		 SqlSession session = MybatisUtils.getSession();
	     UserMapper mapper = session.getMapper(UserMapper.class);
	     List<User> userList = mapper.getUserLike("%a%");
	     for(User user : userList) {
	    	 System.out.println(user);
	     }
	     
	     session.close();//donnot forget 
	 }
}
