package com.leetcode.practice;

public class SortList {

	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode middle = getMiddle(head);
		ListNode right = middle.next;
		middle.next = null;

		ListNode left = sortList(head);
		right = sortList(right);

		return merge(left, right);
	}

	private ListNode getMiddle(ListNode head) {
		if (head == null)
			return head;
		ListNode slow = head;
		while (head != null && head.next != null) {
			slow = slow.next;
			head = head.next.next;
		}
		return slow;
	}

	private ListNode merge(ListNode left, ListNode right) {

		if (left == null)
			return right;
		if (right == null)
			return left;

		if (left.val <= right.val) {
			left.next = merge(left.next, right);
			return left;
		} else {
			right.next = merge(left, right.next);
			return right;
		}
	}

	public static void main(String[] args) {
		int[] arr = {4,2,1,3};
		System.out.println(new SortList().sortList(getInput(arr)));
	}
	
	private static ListNode getInput(int[] arr) {
		
		ListNode head = new ListNode(arr[0]);
		
		ListNode node = head;
		for (int i = 1; i < arr.length; i++) {
			node.next = new ListNode(arr[i]);
			node = node.next;
		}
		return head;
	}

}
