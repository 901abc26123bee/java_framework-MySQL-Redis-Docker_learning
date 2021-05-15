package com.wong.JUC.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {
	public static void main(String[] args) throws InterruptedException {
		test4();
	}
	/**
     * 抛出异常
     */
	public static void test1() {
		//队列的大小
		ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
		System.out.println(blockingQueue.add("a"));//return true or false
		System.out.println(blockingQueue.add("b"));
		System.out.println(blockingQueue.add("c"));
		//java.lang.IllegalStateException: Queue full 抛出异常
		//System.out.println(blockingQueue.add("d"));
		System.out.println(blockingQueue.element());  //查看队首元素是谁
		System.out.println("============================");
		
		System.out.println(blockingQueue.remove());
		System.out.println(blockingQueue.remove());
		System.out.println(blockingQueue.remove());
		//java.util.NoSuchElementException抛出异常
		//System.out.println(blockingQueue.remove());
	}
	
	/**
     * 有返回值没有异常
     */
	public static void test2() {
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);

		System.out.println(arrayBlockingQueue.offer("e"));//return true or false
		System.out.println(arrayBlockingQueue.offer("f"));
		System.out.println(arrayBlockingQueue.offer("g"));
		//System.out.println(arrayBlockingQueue.offer("h"));  // offer 不抛出异常
		System.out.println(arrayBlockingQueue.peek());  //查看队首元素是谁
		
		System.out.println("===================");
		
		System.out.println(arrayBlockingQueue.poll());
		System.out.println(arrayBlockingQueue.poll());
		System.out.println(arrayBlockingQueue.poll());
		//System.out.println(arrayBlockingQueue.poll());  // poll() 不抛出异常
	}

	/**
	 * 等待，阻塞(一直等待)
	 * @throws InterruptedException 
	 */
	public static void test3() throws InterruptedException {
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);

		arrayBlockingQueue.put("i");//没有返回值
		arrayBlockingQueue.put("j");
		arrayBlockingQueue.put("k");
		//arrayBlockingQueue.put("m");  //队列没有位置了，它会一直等待
		
		System.out.println(arrayBlockingQueue.take());
		System.out.println(arrayBlockingQueue.take());
		System.out.println(arrayBlockingQueue.take()); 
		//System.out.println(arrayBlockingQueue.take());  //没有这个元素，一直阻塞
	}
	
	/**
	 * 等待，阻塞(等待超时)
	 * @throws InterruptedException 
	 */
	public static void  test4() throws InterruptedException {
		ArrayBlockingQueue<String> arrayBlockingQueue =  new ArrayBlockingQueue<String>(3);

		arrayBlockingQueue.offer("n");
		arrayBlockingQueue.offer("o");
		arrayBlockingQueue.offer("p");
		// offer(值,时间,时间单位) ===> 如果前面是满，那么久等待2秒，如果还是没有位置，就超时退出
		arrayBlockingQueue.offer("q", 2, TimeUnit.SECONDS);

		System.out.println("============");
	    System.out.println(arrayBlockingQueue.poll());
	    System.out.println(arrayBlockingQueue.poll());
	    System.out.println(arrayBlockingQueue.poll());
	    // poll(时间,时间单位) 等待超过两秒就退出
	    System.out.println(arrayBlockingQueue.poll(2,TimeUnit.SECONDS)); 
	}
}
