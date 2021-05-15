package com.wong.log;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class Log implements MethodBeforeAdvice {

   //method : 要執行的目標對象的方法
   //objects : 被調用的方法的參數
   //target : 目標對象
   public void before(Method method, Object[] objects, Object target) throws Throwable {
       System.out.println( target.getClass().getName() + "的" + method.getName() + "方法被執行了");
  }
}

