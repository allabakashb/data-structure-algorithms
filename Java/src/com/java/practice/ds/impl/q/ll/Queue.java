package com.java.practice.ds.impl.q.ll;

public class Queue<Item> {

	Node first;
	Node last;
	
	private class Node {
		
		Item item;
		Node next;
	}
	
	public void enqueue(Item item) {
		
		Node old = first;
		first = new Node();
		first.item = item;
		first.next = old;
		
		if (first == null) {
			
			last = first;
		}
	}
}
