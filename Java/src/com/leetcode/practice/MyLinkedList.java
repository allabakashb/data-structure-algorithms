package com.leetcode.practice;

public class MyLinkedList {

    class Node {
        
        int val;
        Node next;
        
        Node (int val) {
            this.val = val;
        }
    }
    
    Node start = null;
    Node end = null;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        
        Node head = start;
        int i = 0; 
        
        while (i < index && head != null) {
            
            head = head.next;
            ++i;
        }
        
        return head != null ? head.val : -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (start == null) {
            start = new Node(val);
            end = start;
        } else {
            Node head = new Node(val);
            head.next = start;
            start = head;
        }
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (end == null) {
            end = new Node(val);
            start = end;
        } else {
            end.next = new Node(val);
            end = end.next;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        
        Node head = start;
        int i = 0; 
        
        while (i < (index - 1) && head != null) {
            
            head = head.next;
            ++i;
        }
        
        if (i <= index - 1) {
            Node temp = head.next;
            head.next = new Node(val);
            head.next.next = temp;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        
        if (start == null) return;
        
        Node head = start;
        int i = 0; 
        while (i < (index - 1) && head != null) {
            
            head = head.next;
            ++i;
        }
        
        if (index == 0) {
            
            start = start.next;
            
            if (start == null)
            end = null;
        } else if (head != null && head.next != null) {
            head.next = head.next.next;
        }
    }
    
    public static void main(String[] args) {
		
    	MyLinkedList ml = new MyLinkedList();
    	ml.addAtHead(7);
    	ml.addAtHead(2);
    	ml.addAtHead(1);
    	ml.addAtIndex(3, 0);
    	ml.deleteAtIndex(2);
    	ml.addAtHead(2);
    	ml.addAtTail(6);
    	System.out.println(ml.get(4));
	}
}
