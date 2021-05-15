package com.wong.reflection;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Annotation {
	//注解可以显示复制，如果没有默认值，就必须给注解复制
    @MyAnnotation1(schools = "BUPT")
    public void test(){}
    
    //如果注解只有一个参数可以省略参数名，前提是參數名稱為 vlaue
    @MyAnnotation2("")
    public void test2(){}
}
//定义注解

@Documented //表示把注解生成在Javadoc中
@Inherited //表示可以被继承
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1{
    //注解的参数：类型+参数名()[default 默认值];
    String name() default "";
    int age() default 0;
    int id() default -1;
    String[] schools();
}
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数：类型+参数名()[default 默认值];
    String[] value();
}
