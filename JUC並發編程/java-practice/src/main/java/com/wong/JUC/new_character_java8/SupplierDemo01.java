package com.wong.JUC.new_character_java8;

import java.util.function.Supplier;

/**
 * Supplier 供给型接口：
 * 没有参数，只有返回值
 */
public class SupplierDemo01 {
	public static void main(String[] args) {
		/*
		Supplier<Integer> supplier = new Supplier<>() {
			@Override
			public Integer get() {
				System.out.println("get()");
				return 1024;
			}
		};
		*/
		Supplier<Integer> supplier = ()->{
			System.out.println("get()");
			return 1024;
		};
		System.out.println(supplier.get());
	}
}
