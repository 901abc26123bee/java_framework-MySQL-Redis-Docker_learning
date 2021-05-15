package com.wong.thread;


public class TestSleep implements Runnable{
	public static void main(String[] args) {
		Thread thread = new Thread(()->{
			for(int i=0; i<5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("/////");
		});
		
		
		Thread.State state = thread.getState();
		System.out.println(state);//new
		
		
		thread.start();//start
		state = thread.getState();
		System.out.println(state);
		
		while(state != Thread.State.TERMINATED) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			state = thread.getState();
			System.out.println(state);
			//thread.start();  //error
		}
	}
	

	@Override
	public void run() {
	
	}
}
