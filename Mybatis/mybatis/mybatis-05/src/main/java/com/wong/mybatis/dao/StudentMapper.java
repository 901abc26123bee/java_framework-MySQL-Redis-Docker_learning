package com.wong.mybatis.dao;

import java.util.List;

import com.wong.mybatis.pojo.Student;

public interface StudentMapper {
	//look up all student info and its corresponding teacher info
	public List<Student> getStudents();
	
	//
	public List<Student> getStudent2();
}
