package com.wong.log;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterLog implements AfterReturningAdvice {
	   //returnValue 返回值
	   //method被調用的方法
	   //args 被調用的方法的對象的參數
	   //target 被調用的目標對象
	   public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
	       System.out.println("執行了" + target.getClass().getName()
	       +"的"+method.getName()+"方法,"
	       +"返回值："+returnValue);
	  }
	}
