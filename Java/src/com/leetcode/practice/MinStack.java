package com.leetcode.practice;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinStack {

	 PriorityQueue<Integer> pq;
	    
	    /** initialize your data structure here. */
	    public MinStack() {
	        
	        pq = new PriorityQueue<>();
	    }
	    
	    public void push(int x) {
	        
	        pq.add(x);
	    }
	    
	    public void pop() {
	        
	        pq.poll();
	    }
	    
	    public int top() {
	        
	        return pq.peek();
	    }
	    
	    public int getMin() {
	        return pq.peek();
	    }
	    
	public static void main(String[] args) {
		
		MinStack mst = new MinStack();
		
		mst.push(-2);
		mst.push(0);
		mst.push(-3);
		System.out.println(mst.getMin());
		mst.pop();
		System.out.println(mst.top());
		System.out.println(mst.getMin());

	}

}
