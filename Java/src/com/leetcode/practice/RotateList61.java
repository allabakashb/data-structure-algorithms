package com.leetcode.practice;

public class RotateList61 {
	
	public static void main(String[] args) {
		
		RotateList61 rt = new RotateList61();
		ListNode head = new ListNode(1);
		rt.addData(head, 2, 5);
		rt.print(head);
		head = rt.rotateRight(head, 4);
		System.out.println("");
		rt.print(head);
	}

	public void print(ListNode node) {
		
		if (node == null) return;
		
		System.out.print(node.val + " ");
		print(node.next);
	}
	
	public void addData(ListNode head, int count, int max) {
		
		if (count > max) return;
		
		head.next = new ListNode(count++);
		addData(head.next, count, max);
	}
	
	public ListNode rotateRight(ListNode head, int k) {
        
        int len = getLength(head);
        len = len - (k % len);
        
        if (len == 0 || k == len) return head;
        
        ListNode ref = head;
        
        while (len > 1) {
                    
            len--;
            ref = ref.next;
        }
        
        ListNode temp = head;
        ListNode nextNode = ref;
        ref = ref.next;
        head = ref;
        nextNode.next = null;
        while (ref.next != null) {
            
            ref = ref.next;
        }
        
        ref.next = temp;
        
        return head;
    }
    
    private int getLength(ListNode head) {
        
        if (head == null) return 0;
        
        return getLength(head.next) +  1;
    }
}
