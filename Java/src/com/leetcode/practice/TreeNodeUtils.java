package com.leetcode.practice;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeUtils {
	
	public static TreeNode create(Integer[] arr) {
		TreeNode root = new TreeNode(arr[0]);
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		for (int i = 1; i < arr.length; i++) {
			
			TreeNode node = queue.poll();
			
			if (arr[i] != null) {
				node.left = new TreeNode(arr[i]);
				queue.add(node.left);
			}
			
			if (++i < arr.length && arr[i] != null) {
				node.right = new TreeNode(arr[i]);
				queue.add(node.right);
			}
		}
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}