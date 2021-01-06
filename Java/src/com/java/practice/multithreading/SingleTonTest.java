package com.java.practice.multithreading;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SingleTon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SingleTon() {
		
		System.out.println("created");
	}
	
	private static class St {
		final static SingleTon INSTANCE;		
		static {
			INSTANCE = new SingleTon();
			System.out.println("Inner class Loaded " + INSTANCE);
		}
	}

	public static SingleTon getInstance() {

		System.out.println("ok..");
		return St.INSTANCE;
	}
	
	public static void print() {
		System.out.println("hello");
	}
}

public class SingleTonTest {

	public static void main(String[] args) {

		ExecutorService es = Executors.newFixedThreadPool(5);
		System.out.println("main..");
		for (int i = 0; i < 5; i++) {

			es.submit(() -> {
				SingleTon.print();
				//System.out.println(SingleTon.getInstance());
			});
		}

	}

}
