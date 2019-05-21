package com.threads;

public class TwoExtentendedThreads {

	volatile static Integer number = 10;

	public static void main(String[] args) throws InterruptedException {
		
		Thread1 t1 = new Thread1(number);
		Thread2 t2 = new Thread2(number);
		t2.join();
		t1.join();
	}
}

class Thread1 extends Thread {
	
	Integer number;
	
	Thread1(Integer number) {
		
		this.number = number;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);

			number++;
			System.out.println("Thread 1 :: " + number);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Thread2 extends Thread {
	
	Integer number;
	
	Thread2(Integer number) {
		
		this.number = number;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);

			number++;
			System.out.println("Thread 2 :: " + number);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}