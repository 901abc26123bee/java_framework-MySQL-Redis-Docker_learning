package com.wong.thread;


//測試：生產者消費者模式問題-->利用緩衝區解決：管程法
public class TestPC {
	public static void main(String[] args) {
		SynContainter container = new SynContainter();
		
		new Producer(container).start();
		new Consumer(container).start();
	}
}

class Producer extends Thread{
	SynContainter container;
	
	public Producer(SynContainter containter) {
		this.container = containter;
	}
	@Override
	public void run() {
		for (int i = 0; i <100; i++) {
			container.push(new Chicken(i));
			System.out.println("生產了 "+i+" 只雞");
		}
	}
}

class Consumer extends Thread{
	SynContainter container;
	
	public Consumer(SynContainter containter) {
		this.container = containter;
	}
	@Override
	public void run() {
		for (int i = 0; i <100; i++) {
			System.out.println("消費了--> "+container.pop().id+" 只雞");
		}
	}
}

class Chicken{
	int id;
	public Chicken(int id) {
		this.id = id;
	}
}
//Buffer storehouse
class SynContainter{
	Chicken[] chickens = new Chicken[10];
	int count = 0;

	public synchronized void push(Chicken chicken){
		//storehouse is full, notify consumer to buy, producer to wait
		if(count == chickens.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//if store is not full, continue to push checken(product)
		chickens[count] = chicken;
		count++;
		//notify consumer to buy
		this.notifyAll();
	}
	
	public synchronized Chicken pop() {
		//store house is empty, wait for producer to push chicken
		if(count==0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//store have product, consumber continue buy(pop)
		count--;
		Chicken chicken = chickens[count];
		
		//store is empty, notify producer to push product
		this.notifyAll();
		return chicken;
	}
}