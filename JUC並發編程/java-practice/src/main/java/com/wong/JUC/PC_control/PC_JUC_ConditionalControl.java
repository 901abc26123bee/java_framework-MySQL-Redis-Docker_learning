package com.wong.JUC.PC_control;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//生产线：下单->支付->交易->物流
//A执行完，调用B，B执行完，调用C，C执行完，调用A
public class PC_JUC_ConditionalControl {
	public static void main(String[] args) {
        Date3 data3 = new Date3();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printC();
            }
        },"C").start();
    }
}
//资源类
//Lock锁
class Date3{
	private Lock lock = new ReentrantLock();
	private Condition condition1 = lock.newCondition();
	private Condition condition2 = lock.newCondition();
	private Condition condition3 = lock.newCondition();
	private int number = 1; //假设number为1让A执行，number为2让B执行，number为3让C执行
	 
	public void printA() {
		lock.lock();
		try {
			//业务代码
            //业务，判断->执行->通知
            while (number!=1){
                //等待
                condition1.await();
            }
            //number==1, outprint
            System.out.println(Thread.currentThread().getName()+"==>AAA");
            number = 2;
            condition2.signal();//唤醒,唤醒指定的人,B
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public void printB() {
		lock.lock();
		try {
			//业务代码
            //业务，判断->执行->通知
			while(number!=2) {
				condition2.await();
			}
			System.out.println(Thread.currentThread().getName()+"==>BBB");
			number=3;
			condition3.signal();//唤醒指定的人，C
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public void printC() {
		lock.lock();
		try {
			//业务代码
            //业务，判断->执行->通知
			while(number!=3) {
				condition3.await();
			}
			System.out.println(Thread.currentThread().getName()+"==>CCC");
			number=1;
			condition1.signal();//唤醒指定的人，A
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}