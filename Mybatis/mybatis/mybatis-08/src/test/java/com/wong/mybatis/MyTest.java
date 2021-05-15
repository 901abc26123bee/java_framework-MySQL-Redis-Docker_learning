package com.wong.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wong.mybatis.dao.UserMapper;
import com.wong.mybatis.pojo.User;
import com.wong.mybatis.utils.MybatisUtils;
/*一级缓存小結：
	一级缓存默認下是開啟的（也關閉不了），也就是拿到連接到關閉這個區間段
	只在一次 SqlSession 中有效（SqlSession级别的缓存，也称为本地缓存）
	一级缓存就是一个map
*/

/*
二级缓存小结：
	只要开启了二级缓存，在同一个Mapper下就有效
	所有的数据都会放在一级缓存中
	只有当前会话提交，或者关闭的时候，才会提交到二级缓存中
*/
public class MyTest {
	@Test
	public void testFirstBuffer(){
	   SqlSession session = MybatisUtils.getSession();
	   UserMapper mapper = session.getMapper(UserMapper.class);

	   User user = mapper.queryUserById(1);
	   System.out.println(user);
	   mapper.updateUser(new User(2, "eee", "kkk"));
	   
	   session.clearCache();//手动清除缓存
	   
	   System.out.println("===================");
	   User user2 = mapper.queryUserById(1);
	   System.out.println(user2);
	   System.out.println(user==user2);
	   /*
	    
	    一级缓存也叫本地缓存：SqlSession
	        与数据库同一次会话期间查询到的数据会放在本地缓存中
	        以后如果需要获取相同的数据，直接从缓存中拿，没必要再去查询数据库
	
		测试步骤：
		    开启日志
		    测试在一个Session中查询两次记录
	   */
	   
	   User user3 = mapper.queryUserById(3);
	   System.out.println(user3);
	   /*
	    缓存失效的情况：
		    查询不同的东西
		    增删改操作，可能会改变原来的数据，所以必定会刷新缓存	
		    查询不同的Mapper.xml	
		    手动清理缓存
	    */
	   session.close();
	   
	}
	
	@Test
	public void testSecondBuffer(){
	   SqlSession session = MybatisUtils.getSession();
	   SqlSession session2 = MybatisUtils.getSession();

	   UserMapper mapper = session.getMapper(UserMapper.class);
	   UserMapper mapper2 = session2.getMapper(UserMapper.class);

	   User user = mapper.queryUserById(4);
	   System.out.println(user);
	   session.close();

	   User user2 = mapper2.queryUserById(4);
	   System.out.println(user2);
	   System.out.println(user==user2);

	   session2.close();
	   /*
	    只要开启了二级缓存，我们在同一个Mapper中的查询，可以在二级缓存中拿到数据
	    查出的数据都会被默认先放在一级缓存中
	    只有会话提交或者关闭以后，一级缓存中的数据才会转到二级缓存中
	    */
	}
}
