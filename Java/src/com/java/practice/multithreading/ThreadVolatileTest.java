package com.java.practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadVolatileTest implements Runnable {
	
	volatile static Integer j = 9, k = 10;
	
	public static void main(String[] args) {
			
		ExecutorService es = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 10; i++) {

			es.submit(new ThreadVolatileTest());
		}

	}
	
	@Override
	public void run() {
		 
		//synchronized(ThreadVolatileTest.class) {
			
			int temp = k;
			k = j;
			j = temp;
			
			System.out.println("k = " + k + ", j = " + j);
		//}
	}
}
