package com.java.practice.multipleInheritanceTest;

class Class1 {
	
	@Override
	public String toString() {
		
		return "Class 1 ::";
	}
}

class Class2 extends Class1 {
	
	
}


public class Test {

	public static void main(String[] args) {
		

		Class2 cs = new Class2();
		
		System.out.println(cs);
	}

}
