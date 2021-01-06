package com.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class FirstUnique {

	Map<Integer, Node> map;
    
    Node first = null;
    Node last = null;
    
    class Node {
        
        int val;
        Node next = null;
        Node prev = null;
        boolean removed = false;
        
        Node (int val) {
            
            this.val = val;
        }
    }
    
    private void addNode(Node node) {
        
        if (first == null) {
            
            first = node;
            last = node;
        } else {
            
            last.next = node;
            node.prev = last;
            last = last.next;
        }
    }
    
    private void removeNode(Node node) {
            	
        Node next = node.next; 
        Node prev = node.prev; 
        
        if (next != null) {
            
            if (prev == null) {
                
                first = next;
                next.prev = null;
                
            } else {
                
                next.prev = prev;
                prev.next = next;
            }
        } else if (prev != null) {
            
            last = prev;
            prev.next = null;
        } else {
            
            first = null;
            last = null;
        }
        
        node.next = null;
        node.prev = null;
        node.removed = true;
    }
    
    public FirstUnique(int[] nums) {
        
        map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            add(nums[i]);
        }
    }
    
    public int showFirstUnique() {
        
        if (first == null) return -1;
        
        return first.val;
    }
    
    public void add(int value) {
        
        Node node = map.get(value);
            
        if (node == null) {
            node = new Node(value);
            addNode(node);
            map.put(value, node);
        } else if (!node.removed) {

            removeNode(node);
        }
    }
    
	public static void main(String[] args) {
		
		FirstUnique fu = new FirstUnique(new int[] { 2,3,5,5,3,2,6 });
		
		System.out.println(fu.showFirstUnique());
		
		fu.add(5);
		
		System.out.println(fu.showFirstUnique());
		
		fu.add(2);
		
		System.out.println(fu.showFirstUnique());
		
		fu.add(3);
		
		System.out.println(fu.showFirstUnique());
	}
}
