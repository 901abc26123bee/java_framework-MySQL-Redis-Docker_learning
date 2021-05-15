package com.wong.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.wong.mybatis.pojo.Blog;

public interface BlogMapper {
	//新增一个博客
	int addBlog(Blog blog);
	
	//需求1<where>
	List<Blog> queryBlogIf(Map<?, ?> map);
	//<choose>
	List<Blog> queryBlogChoose(Map<?, ?> map);
	//<set>
	int updateBlog(Map<?, ?> map);
	//需求：我们需要查询 blog 表中 id 分别为1,2,3的博客信息
	List<Blog> queryBlogForeach(Map<?, ?> map);
}
