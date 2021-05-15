package com.wong.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wong.mybatis.dao.BlogMapper;
import com.wong.mybatis.pojo.Blog;
import com.wong.mybatis.utils.MybatisUtils;

public class MyTest {
		/*
	  @Test 
	  public void addInitBlog(){ 
		  SqlSession session = MybatisUtils.getSession(); 
		  BlogMapper mapper = session.getMapper(BlogMapper.class);
	  
		  Blog blog = new Blog(); 
		  blog.setId(IDUtil.genId());
		  blog.setTitle("Mybatis如此简单"); 
		  blog.setAuthor("狂神说"); 
		  blog.setCreateTime(new Date()); 
		  blog.setViews(9999);
		  
		  mapper.addBlog(blog);
		  
		  blog.setId(IDUtil.genId()); 
		  blog.setTitle("Java如此简单");
		  mapper.addBlog(blog);
		  
		  blog.setId(IDUtil.genId()); 
		  blog.setTitle("Spring如此简单");
		  mapper.addBlog(blog);
		  
		  blog.setId(IDUtil.genId()); 
		  blog.setTitle("微服务如此简单"); 
		  mapper.addBlog(blog);
		  
		  session.close(); 
	  }
	 */
	
	@Test
	public void testQueryBlogIf(){
	   SqlSession session = MybatisUtils.getSession();
	   BlogMapper mapper = session.getMapper(BlogMapper.class);

	   HashMap<String, String> map = new HashMap<String, String>();
	   map.put("title","Mybatis如此简单");
	   map.put("author","狂神说");  
	   List<Blog> blogs = mapper.queryBlogIf(map);
	   System.out.println(blogs);

	   session.close();
	}
	
	@Test
	public void testQueryBlogChoose(){
	   SqlSession session = MybatisUtils.getSession();
	   BlogMapper mapper = session.getMapper(BlogMapper.class);

	   HashMap<String, Object> map = new HashMap<String, Object>();
	   //map.put("title","Java如此简单");
	   map.put("author","狂神说");
	   map.put("views",9999);
	   List<Blog> blogs = mapper.queryBlogChoose(map);

	   System.out.println(blogs);

	   session.close();
	}
	
	@Test
	public void testUpdateBlog(){
	   SqlSession session = MybatisUtils.getSession();
	   BlogMapper mapper = session.getMapper(BlogMapper.class);

	   HashMap<String, String> map = new HashMap<String, String>();
	   map.put("title","Mybatis如此简单");
	   map.put("author","秦疆");
	   map.put("id","1");

	   mapper.updateBlog(map);

	   session.close();
	}
	
	@Test
	public void queryBlogForeach() {
		SqlSession session = MybatisUtils.getSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		//傳入型態="map" 
		HashMap<Object, Object> map = new HashMap<>();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		map.put("ids", ids);
		//遍歷其中 key 為 ids 的集合(list)
		List<Blog> blogs = mapper.queryBlogForeach(map);
	    System.out.println(blogs);

	    session.close();
	}
}
