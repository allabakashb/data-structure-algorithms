package com.june2020.practice;

public class StackCustom {

	class Node {
		
		int val;
		Node next;
		
		Node(int val) {
			
			this.val = val;
		}
	}
	
	Node first;
	
	public void push(int val) {
		
		Node newNode = new Node(val);
		newNode.next = first;
		first = newNode;
	}
	
	public int pop() {
		
		if (first == null) throw new IllegalArgumentException();
		
		int val = first.val;
		
		first = first.next;
		
		return val;
	}
	
	public int peek() {
		
		if (first == null) throw new IllegalArgumentException();
		
		return first.val;
	}
	
	public static void main(String[] args) {
		
		StackCustom stack = new StackCustom();
		
		stack.push(1);
		stack.push(2);
		System.out.println(stack.peek());
		stack.push(3);
		System.out.println(stack.peek());
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(5);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

}
