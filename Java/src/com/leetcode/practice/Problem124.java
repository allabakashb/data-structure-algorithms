package com.leetcode.practice;

import com.leetcode.practice.PathSum112.TreeNode;

public class Problem124 {

	int maxSum = Integer.MIN_VALUE;

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int maxPathSum(TreeNode root) {

		maxSum = Integer.MIN_VALUE;

		dfs(root);

		return maxSum;
	}

	private int dfs(TreeNode root) {

		if (root == null)
			return 0;

		int path1 = maxPathSum(root.left);
		int path2 = maxPathSum(root.right);

		maxSum = Math.max(maxSum, (root.val + path1 + path2));

		maxSum = Math.max(maxSum, root.val);

		return Math.max(path1, path2) + root.val;
	}

	private TreeNode create() {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		
		return root;
	}
	
	public static void main(String[] args) {
		
		Problem124 p = new Problem124();
		
		System.out.println(p.maxPathSum(p.create()));
	}

}
