package com.wong.mybatis.pojo;

import lombok.Data;


@Data
public class Student {
	private int id;
	private String name;
	
	//多个学生關聯同一个老师，即多对一
	private Teacher teacher;
}
