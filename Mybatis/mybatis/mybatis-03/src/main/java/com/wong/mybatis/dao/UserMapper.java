package com.wong.mybatis.dao;


import java.util.List;
import java.util.Map;

import com.wong.mybatis.pojo.User;

public interface UserMapper {
	
	//look up user by ID
	User getUserById(int id);
	
	//选择全部用户实现分页
	List<User> getUserByLimit(Map<String,Integer> map);
	
	//选择全部用户RowBounds实现分页
	List<User> getUserByRowBounds();


}
