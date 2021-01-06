package com.leetcode.practice;

public class PathSum112 {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private TreeNode create() {
					
		TreeNode root = new TreeNode(-2);
		root.right = new TreeNode(-3);
		
		return root;
	}
 

	public static void main(String[] args) {
		
		PathSum112 ps = new PathSum112();
		TreeNode root = ps.create();
		System.out.println(ps.hasPathSum(root, -5));

	}
	
	 public boolean hasPathSum(TreeNode root, int sum) {
         
	        return hasPathSum(root, sum, 0);
	    }
	    
	    private boolean hasPathSum(TreeNode root, int sum, int sumSoFar) {
	        
	        if (root == null) return false;

	        sumSoFar += root.val;

	        if (sum == sumSoFar && root.left == null && root.right == null) return true;
	        	                
	        return hasPathSum(root.left, sum, sumSoFar) || 
	            hasPathSum(root.right, sum, sumSoFar);
	    }

}
