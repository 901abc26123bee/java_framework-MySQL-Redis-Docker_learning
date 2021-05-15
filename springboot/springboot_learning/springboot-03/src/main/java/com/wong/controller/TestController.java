package com.wong.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
//	@RequestMapping("/test")
//	public String test1(Model model){
//	    //存入數據
//	    model.addAttribute("msg","Hello,Thymeleaf");
//	    //classpath:/templates/test.html
//	    return "test";
//	}
	@RequestMapping("/test")
	public String test2(Map<String,Object> map){
	    //存入數據
	    map.put("msg","<h1>Hello</h1>");
	    map.put("users", Arrays.asList("atom","emac"));
	    //classpath:/templates/test.html
	    return "test";
	}
}
