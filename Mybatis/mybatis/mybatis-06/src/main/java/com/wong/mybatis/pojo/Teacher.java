package com.wong.mybatis.pojo;

import java.util.List;

import lombok.Data;

@Data 
public class Teacher {
	private int id;
	private String name;
	//一个老师對（包含）多个学生
	private List<Student> students;
}
