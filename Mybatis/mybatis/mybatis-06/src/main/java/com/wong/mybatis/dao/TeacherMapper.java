package com.wong.mybatis.dao;

import org.apache.ibatis.annotations.Param;

import com.wong.mybatis.pojo.Teacher;

public interface TeacherMapper {
	//获取指定老师，及老师下的所有学生
	public Teacher getTeacher(@Param("tid")int id);
	
	//获取指定老师，及老师下的所有学生
	public Teacher getTeacher2(@Param("tttid")int id);
}
