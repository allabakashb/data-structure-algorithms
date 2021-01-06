package com.leetcode.practice;

public class Problem142 {

	public ListNode detectCycle(ListNode head) {

		ListNode slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) break;
		}

		if (fast == null || fast.next == null)
			return null;

		while (fast != head) {
			fast = fast.next;
			head = head.next;
		}

		return fast;
	}

	public static void main(String[] args) {
		int[] arr = { 3,2,0,-4 };
		int tail = 1;
		System.out.println(new Problem142().detectCycle(getInput(arr, tail)).val);
	}
	
	private static ListNode getInput(int[] arr, int tail) {
		
		ListNode head = new ListNode(arr[0]);
		ListNode node = head, tailHead = tail == 0 ? head : null;
		
		for (int i = 1; i < arr.length; i++) {
			node.next = new ListNode(arr[i]);
			node = node.next;
			if (i == tail) tailHead = node;
		}
		
		node.next = tailHead;
		return head;
	}

}
