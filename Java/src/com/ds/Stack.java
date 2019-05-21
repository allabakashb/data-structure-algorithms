package com.ds;

public class Stack {

	Node current = null;
	
	private class Node {
		
		int value;
		Node next;
	}
	
	
	public boolean isEmpty() {
		
		return current == null;
	}
	
	public void push(int value) {
		
		Node prev = current;
		
		current = new Node();
		current.next = prev;
		current.value = value;
	}
	
	public int pop() {
		int value = current.value;
		current = current.next;
		return value;
	}
}
