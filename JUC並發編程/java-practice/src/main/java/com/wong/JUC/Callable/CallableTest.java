package com.wong.JUC.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//细节：
//有缓存
//结果可能需要等待，会阻塞！

public class CallableTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//new Thread(new MyThread()).start();
		
		//Thread怎么启动Callable
//      new Thread(new Runnable()).start();
//      new Thread(new FutureTask<V>()).start();
//      new Thread(new FutureTask<V>(Callable)).start();
		new Thread().start();
		
		MyThread myThread = new MyThread();
        FutureTask<String> futureTask = new FutureTask<>(myThread);//适配类
        new Thread(futureTask,"A").start(); //Thread调用Callable
        new Thread(futureTask,"B").start(); //结果会被缓存，效率高
        new Thread(futureTask,"C").start();
        //這個get方法可能會產生阻塞
        //解決方案：1. 放到最後 2. 使用異步通信来处理
        String o = (String) futureTask.get();//获取Callable的返回值
        System.out.println(o);
	}
}
//泛型的參數等於方法返回值類型
class MyThread implements Callable<String>{
	@Override
    public String call() throws Exception {
        System.out.println("call()");
        return "10458577717";
    }
}