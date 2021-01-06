package com.java.practice.ds.impl;

import com.java.practice.ds.impl.st.ll.Stack;

public class StackTest {

	public static void main(String[] args) {
		
		Stack<Integer> stLL = new Stack<Integer>();
		com.java.practice.ds.impl.st.ar.Stack<Integer> stAR = new com.java.practice.ds.impl.st.ar.Stack<Integer>();

		for (int i = 0; i < 10; i++) {
			
			stLL.push(i);
			stAR.push(i);
			System.out.print(i + " ");
		}
		
		System.out.println("");
		while(!stLL.isEmpty()) {
			
			System.out.print(stLL.pop() + " ");
		}
		
		System.out.println("");
		while(!stAR.isEmpty()) {
			
			System.out.print(stAR.pop() + " ");
		}
	}
}

