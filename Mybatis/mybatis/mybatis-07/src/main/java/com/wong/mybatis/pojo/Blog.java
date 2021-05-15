package com.wong.mybatis.pojo;

import java.util.Date;

import lombok.Data;

@Data
public class Blog {
	private String id;
	private String title;
	private String author;
	//(java)屬姓名createTime 和 (mysql)字段名create_time 不一致
	private Date createTime;
	private int views;
}
