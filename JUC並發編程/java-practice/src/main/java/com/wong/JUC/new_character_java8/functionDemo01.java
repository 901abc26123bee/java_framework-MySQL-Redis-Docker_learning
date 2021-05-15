package com.wong.JUC.new_character_java8;

import java.util.function.Function;

/**
 * Function 函数型接口
 * 有一个输入参数，有一个输出
 * 只要是函数式接口 可以 用Lambda表达式简化
 */
public class functionDemo01 {
	public static void main(String[] args) {
		//工具类：输出输入的值
		/*
		Function<String, String> function = new Function<String, String>() {
			@Override
			public String apply(String str) {
				return str;
			}
		};
		System.out.println(function.apply("ads"));
		*/
		
		//()->{};
		Function<String, String> function = (str) ->{return str;};
		System.out.println(function.apply("ads"));
	}
}
