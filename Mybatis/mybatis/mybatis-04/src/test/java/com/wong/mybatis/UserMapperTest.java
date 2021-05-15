package com.wong.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wong.mybatis.dao.UserMapper;
import com.wong.mybatis.pojo.User;
import com.wong.mybatis.utils.MybatisUtils;
//在工具類創建時，實現自動提交事務
public class UserMapperTest {

	@Test
	public void getAllUser() {
		SqlSession sqlSession = MybatisUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = mapper.getAllUser();
		for(User user : users) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	@Test
	public void getUserByID() {
		SqlSession sqlSession = MybatisUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User userByID = mapper.getUserByID(1);
 		System.out.println(userByID);
		
		sqlSession.close();
	}
	
	@Test
	public void addUser() {
		SqlSession sqlSession = MybatisUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User(5,"dolaamo", "589027");
		mapper.addUser(user);
		
		sqlSession.close();
	}
	
	@Test
	public void updateUser() {
		SqlSession sqlSession = MybatisUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User(6,"dola", "589027");
		mapper.updateUser(user);
		
		sqlSession.close();
	}
	

	@Test
	public void deleteUser() {
		SqlSession sqlSession = MybatisUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		mapper.deleteUser(7);
		
		sqlSession.close();
	}

}
