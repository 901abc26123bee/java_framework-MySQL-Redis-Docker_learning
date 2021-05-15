package com.wong.JUC.new_character_java8;

import java.util.function.Consumer;

/**
 * Consumer 消费型接口：
 * 只有输入，没有返回值
 */
public class ConsumerDemo01 {
	public static void main(String[] args) {
		/*
		Consumer<String> consumer = new Consumer<>() {
			@Override
			public void accept(String str) {
				System.out.println(str);
			}
		};
		*/
		Consumer<String> consumer = (str)->{System.out.println(str);};
		consumer.accept("asd");
	}
}
