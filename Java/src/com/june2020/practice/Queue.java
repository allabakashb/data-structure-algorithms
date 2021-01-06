package com.june2020.practice;

public class Queue {

	class Node {
		
		int val;
		Node next;
		
		Node(int val) {
			
			this.val = val;
		}
	}
	
	Node first;
	Node last;
	
	public void add(int val) {
		
		if (first == null) {
			
			first = new Node(val);
			last = first;
		} else {
			
			last.next = new Node(val);
			last = last.next;
		}
	}
	
	public int poll() {
		
		if (first == null) throw new IllegalArgumentException();
		
		int val = first.val;
		
		first = first.next;
		
		if (first == null) last = first;
		
		return val;
	}
	
	public int peek() {
		
		return first.val;
	}
	
	public static void main(String[] args) {
		
		Queue queue = new Queue();
		
		queue.add(1);
		queue.add(2);
		System.out.println(queue.peek());
		queue.add(3);
		System.out.println(queue.peek());
		queue.add(4);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		queue.add(5);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}

}
