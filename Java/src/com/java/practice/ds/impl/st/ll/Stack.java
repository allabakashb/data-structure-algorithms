package com.java.practice.ds.impl.st.ll;

public class Stack<Item> {
	
	Node node;
	
	private class Node {
		
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		
		return node == null;
	}
	
	public Item pop() {
		
		Item item = node.item;
		node = node.next;
		
		return item;
	}
	
	public void push(Item item) {
		
		Node oldNode = node;
		node = new Node();
		node.item = item;
		node.next = oldNode;
	}
}