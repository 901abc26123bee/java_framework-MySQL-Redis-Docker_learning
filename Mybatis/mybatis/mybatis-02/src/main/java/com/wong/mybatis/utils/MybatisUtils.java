package com.wong.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//SqlSessionFactory --> SqlSession
public class MybatisUtils {
	private static SqlSessionFactory sqlSessionFactory;//提升作用域
	
	//加載資源
	static {
	      try {
	    	   //use mybatis step1:獲取sqlSessionFactory對象
	           String resource = "mybatis-config.xml";
	           InputStream inputStream = Resources.getResourceAsStream(resource);
	           sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	      } catch (IOException e) {
	           e.printStackTrace();
	      }
	 }
	  //創造對象
	  //有了sqlSessionFactory，就可以從中獲得SqlSession實例
	  //SqlSession完全包含面向數據庫執行 sql 命令所需的所有方法
	  //获取SqlSession连接
	  public static SqlSession getSession(){
	      return sqlSessionFactory.openSession();
	 }
}

