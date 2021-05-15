package com.wong.mybatis.dao;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.wong.mybatis.pojo.User;
import com.wong.mybatis.utils.MybatisUtils;


public class UserMapperTest {
	 static Logger logger = Logger.getLogger(UserMapperTest.class);
	
	 @Test
	 public void getUserList() {
	       SqlSession session = MybatisUtils.getSession();
	       //方法一:
	       //List<User> users = session.selectList("com.kuang.mapper.UserMapper.selectUser");
	       //方法二:
	       UserMapper mapper = session.getMapper(UserMapper.class);
	       User user = mapper.getUserById(1);

	       System.out.println(user);
	       
	       session.close();//donnot forget

	  }
//  select * from mybatis.user where id = #{id}
//  類型處理器
//mybatis会根据这些查询的列名
//(会将列名转化为小写,数据库不区分大小写) , 去对应的实体类中查找相应列名的set方法设值 , 
//由于找不到setPwd() , 所以password返回null ; 【自动映射】
	 
//  select id, name, pwd from mybatis.user where id = #{id}	 
	 
	 @Test
	 public void testLog4j() {
	    logger.info("info：进入selectUser方法");
	    logger.debug("debug：进入selectUser方法");
	    logger.error("error: 进入selectUser方法");
	 }
	 
	 @Test
	 public void getUserByLimit() {
		 SqlSession session = MybatisUtils.getSession();
		 UserMapper mapper = session.getMapper(UserMapper.class);
		 
		 HashMap<String, Integer> map = new HashMap<String, Integer>();
		 map.put("startIndex", 0);
		 map.put("pageSize", 2);
		 
		 List<User> userList = mapper.getUserByLimit(map);
		 for(User user : userList) {
			 System.out.println(user);
		 }
		 session.close();//donnot forget
	 }

	 @Test
	 //not recommand
	 public void testUserByRowBounds() {
	    SqlSession session = MybatisUtils.getSession();

	    int currentPage = 2;  //第几页
	    int pageSize = 2;  //每页显示几个
	    RowBounds rowBounds = new RowBounds((currentPage-1)*pageSize,pageSize);

	    //通过session.**方法进行传递rowBounds，[此种方式现在已经不推荐使用了]
	    List<User> users = session.selectList("com.wong.mybatis.dao.UserMapper.getUserByRowBounds", null, rowBounds);

	    for (User user: users){
	        System.out.println(user);
	   }
	    session.close();
	 }
}
