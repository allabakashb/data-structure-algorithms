package com.threads;

public class TwoRunnableThreads {

	volatile static Integer number = 10;

	public static void main(String[] args) {
		
		Thread3 t1 = new Thread3(number);
		Thread4 t2 = new Thread4(number);
		t1.run();
		t2.run();
	}
}

class Thread3 implements Runnable {
	
	Integer number;
	
	Thread3(Integer number) {
		
		this.number = number;
	}
	
	@Override
	public void run() {
		try {
			number++;
			System.out.println("Thread 1 :: " + number);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Thread4 implements Runnable {
	
	Integer number;
	
	Thread4(Integer number) {
		
		this.number = number;
	}
	
	@Override
	public void run() {
		try {
			number++;
			System.out.println("Thread 2 :: " + number);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}