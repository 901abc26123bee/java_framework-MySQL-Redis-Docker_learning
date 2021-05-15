package com.wong.JUC.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用：Ajax
 * 异步执行
 * 成功回调
 * 失败回调
 * CompletableFuture
 * Comple(康配额)
 * Future(费油特)
 */
public class Demo01 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//没有返回值的异步回调
		//test1();
	    //有返回值的异步调用
	    test2();
	}
	
	//没有返回值的 runAsync 异步回调
	private static void test1() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+ " runAsync => Void");
		});
		System.out.println("888888");
		completableFuture.get();//获取阻塞执行结果
	}
	
	//有返回值的 supplyAsync 异步回调
    //ajax，成功和失败的回调
	private static void test2() throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
			System.out.println(Thread.currentThread().getName()+" supplyAsync => Integer");
			//int i = 10/0;
			return 1024;
		});
		//BiConsumer 只要是只有参数没有返回值就是消费型接口
        //whenComplete参数t获取supplyAsync的返回结果,u获取错误的信息,没有错误则为null
		System.out.println(completableFuture.whenCompleteAsync((t, u)->{
			System.out.println("t=> "+t);//正常的返回结果
			System.out.println("u=> "+u);//错误信息 
			//u=> java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
		}).exceptionally((e)->{
			System.out.println(e.getMessage());//java.lang.ArithmeticException: / by zero
			return 233;//可以获取到错误的返回结果
		}).get());
		/**
         * success Code 200
         * error Code 404 500
         */
	}
}
