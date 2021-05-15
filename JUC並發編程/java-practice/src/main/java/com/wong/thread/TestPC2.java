package com.wong.thread;

//測試：生產者消費者模式問題-->利用標誌位解決：信號燈法
public class TestPC2 {
	public static void main(String[] args) {
		TV tv = new TV();
		new Player(tv).start();
		new Watcher(tv).start();
	}
}

//生產者-->演員
class Player extends Thread{
	TV tv;
	public Player(TV tv) {
		this.tv = tv;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if(i%2 == 0) {
				this.tv.play("OneReplublic : Serect");
			}else {
				this.tv.play("Sam Smith : Writing on the wall");
			}
		}
	}
}

//消費者-->觀眾
class Watcher extends Thread{
	TV tv;
	public Watcher(TV tv) {
		this.tv = tv;
	}
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			tv.watch();
		}
	}
}

//產品-->節目
class TV{
	//player play, watcher wait
	//watcher watch, player wait
	String voice;//TV program
	boolean flag = true;//true--> watcher watch;  false-->player play
	
	public synchronized void play(String voice) {
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Player plays: "+voice);
		//notify watcher to watch
		this.notifyAll();
		this.voice = voice;
		this.flag = !flag;
	}
	
	public synchronized void watch() {
		//if(flag == false) --> the Player has played voice, watcher can watch
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Watcher watch: "+voice);
		
		//after watching, notify Player tpo play
		this.notifyAll();
		this.flag = !flag;
	}
}