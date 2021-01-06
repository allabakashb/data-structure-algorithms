package com.java.practice.multithreading;

public class StaticExecutionTest {

	{
		System.out.println("Non Static1..");
	}
	
	public StaticExecutionTest() {
		System.out.println("Cons...");
	}
	
	static {
		System.out.println("Static1...");
	}
	
	public static void main(String[] args) {
		System.out.println("Main");

		new StaticExecutionTest();
	}

	static {
		System.out.println("Static2...");
	}
	
	{
		System.out.println("Non Static2..");
	}
}
