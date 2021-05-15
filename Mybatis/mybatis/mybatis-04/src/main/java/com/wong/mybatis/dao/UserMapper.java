package com.wong.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wong.mybatis.pojo.User;

public interface UserMapper {
	//查询全部用户
	@Select("select * from mybatis.user")
	public List<User> getAllUser();
	
	//方法存在多個參數，所有參數前面必須加上  @Param("參數name")
	//@Param("參數name") must match the name in  sql #{參數name}
	//User getUserByID(@Param("id")int id, @Param("name") String name);
	@Select("select * from mybatis.user where id = #{idd}")
	User getUserByID(@Param("idd")int id);
	
	//添加一个用户
	@Insert("insert into user (id,name,pwd) values (#{id},#{name},#{pwd})")
	int addUser(User user);
	
	//修改一个用户
	@Update("update user set name=#{name},pwd=#{pwd} where id = #{id}")
	int updateUser(User user);
	
	//根据id删除用
	@Delete("delete from user where id = #{id}")
	int deleteUser(@Param("id")int id);
}
