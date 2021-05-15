package com.wong.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationPointcut {
   @Before("execution(* com.wong.service.UserServiceImpl.*(..))")
   public void before(){
       System.out.println("---------方法執行前---------");
  }

   @After("execution(* com.wong.service.UserServiceImpl.*(..))")
   public void after(){
       System.out.println("---------方法執行後---------");
  }

   @Around("execution(* com.wong.service.UserServiceImpl.*(..))")
   public void around(ProceedingJoinPoint jp) throws Throwable {
       System.out.println("環繞前");
       System.out.println("簽名:"+jp.getSignature());
       //執行目標方法proceed
       Object proceed = jp.proceed();
       System.out.println("環繞後");
       System.out.println(proceed);
  }
}
