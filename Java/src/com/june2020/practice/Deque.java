package com.june2020.practice;

public class Deque {

	private class Node {
		
		int val;
		Node prev;
		Node next;
		
		Node(int val) {
			
			this.val = val;
		}
	}
	
	private Node first;
	private Node last;
	
	public void addFirst(int val) {
		
		if (first == null) {
			
			first = new Node(val);
			last = first;
		} else {
			
			Node newNode = new Node(val);
			first.prev = newNode;
			newNode.next = first;
			first = newNode;
		}
	}
	
	public void addLast(int val) {
		
		if (last == null) {
			
			last = new Node(val);
			first = last;
		} else {
			
			Node newNode = new Node(val);
			last.next = newNode;
			newNode.prev = last;
			last = newNode;
		}
	}
	
	public int removeFirst() {
		
		if (first == null) throw new IllegalArgumentException();
		
		int val = first.val;
		first = first.next;

		if (first == null) {
			
			last = null;
		} else {
			
			first.prev = null;
		}
		
		return val;
	}
	
	public int removeLast() {
		
		if (last == null) throw new IllegalArgumentException();
		
		int val = last.val;
		
		last = last.prev;
		
		if (last == null) {
			
			first = null;
		} else {
			
			last.next = null;
		}
		
		return val;
	}
	
	public int getFirst() {
		
		if (first == null) throw new IllegalArgumentException();
		
		return first.val;
	}
	
	public int getLast() {
		
		if (last == null) throw new IllegalArgumentException();
		
		return last.val;
	}
	
	public static void main(String[] args) {
		
		Deque dq = new Deque();
		dq.addFirst(2);
		System.out.println("First => " + dq.getFirst());
		System.out.println("Last => " + dq.getLast());
		dq.addFirst(1);
		System.out.println("First => " + dq.getFirst());
		System.out.println("Last => " + dq.getLast());
		dq.addLast(3);
		System.out.println("First => " + dq.getFirst());
		System.out.println("Last => " + dq.getLast());
		System.out.println("First => " + dq.getFirst());
		System.out.println("Last => " + dq.getLast());
		System.out.println("R Last => " + dq.removeLast());
		System.out.println("R First => " + dq.removeFirst());
		System.out.println("First => " + dq.getFirst());
		System.out.println("Last => " + dq.getLast());
		System.out.println("R First => " + dq.removeFirst());
	}

}
