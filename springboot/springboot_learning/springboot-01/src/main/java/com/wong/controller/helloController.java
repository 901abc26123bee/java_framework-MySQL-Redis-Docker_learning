package com.wong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
	
	//接口 : http://localhost:8080/hello
	@RequestMapping("/hello")
	public String hello() {
		//調用業務，接收前端的業務
		return "hello World";
	}
}
