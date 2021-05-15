package com.wong.mybatis.dao;


import java.util.List;

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

}
