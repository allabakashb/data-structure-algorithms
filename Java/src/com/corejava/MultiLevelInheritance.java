package com.corejava;

public class MultiLevelInheritance extends B{
	
	private int k = 60;
	public static void main(String[] args) {
		
		MultiLevelInheritance ml = new MultiLevelInheritance();
		
		System.out.println(ml.z);
	}
}


class A {
	private int x = 10;
	protected int y = 20;
	int z = 30;
}

class B extends A {
	private int S = 40;
}