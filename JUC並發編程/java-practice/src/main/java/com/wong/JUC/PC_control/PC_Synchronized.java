package com.wong.JUC.PC_control;

//线程之间的通信问题：生产者和消费者问题！等待唤醒，通知唤醒
//线程交替执行 A线程，B线程操作同一个变量，  num=0
//A  num+1
//B  num-1
public class PC_Synchronized {
	public static void main(String[] args) {
		Data data = new Data();
		
		new Thread(()->{
			for(int i=0; i<10; i++) {
				try {
					data.increment();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "a").start();
		
		new Thread(()->{
			for(int i=0; i<10; i++) {
				try {
					data.decrement();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "b").start();
		
		//**问题存在：A,B,C,D或者两个以上的线程就会存在问题！虚假唤醒**
		/*
		 	if判断改为while判断
			因为if只会执行一次，执行完会接着向下执行if（）外边的
			***而while不会，直到条件满足才会向下执行while（）外边的*** 
		 */
		new Thread(()->{
			for(int i=0; i<10; i++) {
				try {
					data.increment();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "c").start();
		
		new Thread(()->{
			for(int i=0; i<10; i++) {
				try {
					data.decrement();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "d").start();
	}
}

//判斷是否需要等待，業務，通知
//数字，资源类
class Data{
  private int number = 0;
  //+1
  public synchronized void increment() throws InterruptedException {
	  //判斷是否需要等待
	  while(number!=0){
          //等待
          this.wait();
      }
      number++;
      System.out.println(Thread.currentThread().getName()+"==>"+number);
      //通知其他线程，我+1完毕了
      this.notifyAll();
  }
  //-1
  public synchronized void decrement() throws InterruptedException {
	  //判斷是否需要等待
	  while(number==0){
          //等待
          this.wait();
      }
      number--;
      System.out.println(Thread.currentThread().getName()+"==>"+number);
      //通知其他线程，我-1完毕了
      this.notifyAll();
  }
}