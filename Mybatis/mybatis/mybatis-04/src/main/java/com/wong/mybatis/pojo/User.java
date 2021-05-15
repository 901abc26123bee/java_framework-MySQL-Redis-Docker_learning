package com.wong.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//<artifactId>lombok</artifactId>
//<version>1.18.12</version>
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
    private int id;  //id
    private String name;   //姓名
    private String password;   //密码，和 MySQL 中表名不一
    
    
}