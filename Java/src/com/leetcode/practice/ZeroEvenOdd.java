package com.leetcode.practice;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

	private int n;
	Semaphore sm = new Semaphore(1);
	
	AtomicInteger ai = new AtomicInteger(0);
	AtomicInteger counter1 = new AtomicInteger(0);
	AtomicInteger counter2 = new AtomicInteger(2);

	int index = 0;

	public ZeroEvenOdd(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			
			
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {

		while (index < 2 * n) {

			if (counter1.get() != 0 && counter2.get() % 2 == 0) {
				counter2.set(2);
				printNumber.accept(ai.incrementAndGet());
				++index;
				counter1.set(0);
			}
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {

		while (index < 2 * n) {

			if (counter1.get() != 0 && counter2.get() % 2 != 0) {
				counter2.set(1);
				printNumber.accept(ai.incrementAndGet());
				++index;
				counter1.set(0);
			}
		}
	}

	public static void main(String[] args) {

		ZeroEvenOdd zedEvenOdd = new ZeroEvenOdd(100);
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					zedEvenOdd.zero(getIntConsumer());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					zedEvenOdd.even(getIntConsumer());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					zedEvenOdd.odd(getIntConsumer());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
	}

	private static IntConsumer getIntConsumer() {
		return new IntConsumer() {
			
			@Override
			public void accept(int value) {
				
				System.out.print(value);
			}
		};
	}
}
