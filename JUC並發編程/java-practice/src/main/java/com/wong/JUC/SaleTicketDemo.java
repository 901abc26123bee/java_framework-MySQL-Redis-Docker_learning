package com.wong.JUC;



public class SaleTicketDemo {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		new Thread(()->{
			for(int i=0; i<40; i++)
				ticket.sale();
		}, "a").start();
		
		new Thread(()->{
			for(int i=0; i<40; i++)
				ticket.sale();
		}, "b").start();
	
		new Thread(()->{
			for(int i=0; i<40; i++)
				ticket.sale();
		}, "c").start();
	}
}

class Ticket{
	private int ticketNum = 30;
	//同步方法
	public synchronized void sale() {
		//同步塊：可以鎖任何對象
		//鎖的對象就是變化的量，需要增刪改的對象
		//synchronized(this){}
		
		if(ticketNum>0) {
			System.out.println(Thread.currentThread().getName() + "賣出了" +(ticketNum--) + "票，剩餘" + ticketNum);
		}
	}
}