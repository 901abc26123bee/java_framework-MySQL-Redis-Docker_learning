package com.wong.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	//接口 : http://localhost:8080/index
	@RequestMapping({"/", "/index"})
	public String toIndex(Model model) {
		//調用業務，接收前端的業務
		model.addAttribute("msg", "hello Shiro");
		return "index";
	}
	
	@RequestMapping("/user/add")
	public String add() {
		return "user/add";
	}
	
	@RequestMapping("/user/update")
	public String update() {
		return "user/update";
	}
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("/login") // 從前端頁面接收用戶數據
    public String login(String username, String password, Model model) {
        //獲取一個用戶
        Subject subject = SecurityUtils.getSubject();
        // 封裝用戶的登錄數據
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);//執行登錄的方法，如果沒有異常就說明ok了
            return "index";
        } catch (UnknownAccountException e) {//用戶名不存在
            model.addAttribute("msg","用戶名錯誤");
            return "login";
        } catch (IncorrectCredentialsException e) {//密碼不存在
            model.addAttribute("msg","密碼錯誤");
            return "login";
        }
    }

    @RequestMapping("/noauto")
    @ResponseBody
    public String unauthorized() {
        return "未經授權，無法訪問此頁面";
    }
}
