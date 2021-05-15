package com.wong.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("user")
@Scope("singleton")
//相當於配置文件中 <bean id="user" class="當前註解的類"/>
public class User {
	@Value("wong")
	 public String name;
}
