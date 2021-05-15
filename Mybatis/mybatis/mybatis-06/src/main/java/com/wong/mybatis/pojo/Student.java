package com.wong.mybatis.pojo;

import lombok.Data;


@Data
public class Student {
	
	//variable name match property in StudentMapper
	private int propertyid;
	private String name;
	private int tid;
}
