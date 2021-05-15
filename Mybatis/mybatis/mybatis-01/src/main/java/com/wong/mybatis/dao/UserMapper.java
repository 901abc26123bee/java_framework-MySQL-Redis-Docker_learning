package com.wong.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.wong.mybatis.pojo.User;

public interface UserMapper {
	//look up all user
	List<User> getUserList();
	
	//look up user by ID
	User getUserById(int id);
	
	//insert a User
	int addUser(User user);
	
	//萬能Map
	int addUser2(Map<String, Object> map);
	
	//modified a User
	int updateUser(User user);
	
	//根据id删除用户
	int deleteUser(int id);
	//模糊查询like
	List<User> getUserLike(String value);
}
