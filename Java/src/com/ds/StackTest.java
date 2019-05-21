package com.ds;

public class StackTest {

	public static void main(String[] args) {
		
		Stack st = new Stack();
		
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		System.out.println(st.pop());
		st.push(5);
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.isEmpty());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.isEmpty());
	}

}
