package com.wong.thread;


public class UnsafeBank {
	public static void main(String[] args) {
		Account account = new Account(100, "fund");
		Drawing you = new Drawing(account, 50 ,"you");
		Drawing friend = new Drawing(account, 100 ,"friend");
		
		you.start();
		friend.start();
	}
}
//帳戶
class Account{
	int money;//餘額
	String name;//卡名
	
	public Account(int money, String name) {
		this.money = money;
		this.name = name;
	}
}
//銀行：模擬取款
class Drawing extends Thread{
	Account account;//帳戶
	int drawingMoney;//取多少錢
	int nowMoney;//現在手裡有多少錢
	
	public Drawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	//取錢
	//synchronized 默認鎖的值是 this.
	//public synchronized void run() 鎖的值是 Drawing(=bank)
	public void run() {
		//同步塊：可以鎖任何對象
		//鎖的對象就是變化的量，需要增刪改的對象
		synchronized (account) {
			if(account.money-drawingMoney<0) {
				System.out.println(Thread.currentThread().getName()+"not enough money,cannot draw");
				return;
			}
			//sleep() magnify the posibility of having problem
			//mimic network delay to encounter error that money in bank=-50
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
			//money in your account
			account.money = account.money - drawingMoney;
			//money in your hand
			nowMoney = nowMoney + drawingMoney;
			System.out.println(account.name+" (bank)remanent money : "+account.money);
			//Thread.currentThread().getName() = this.getName()
			System.out.println(this.getName()+" (person)remanent money : "+nowMoney);

		}		
	}
}
