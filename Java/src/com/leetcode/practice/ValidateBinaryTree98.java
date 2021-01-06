package com.leetcode.practice;

public class ValidateBinaryTree98 {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private TreeNode create(Integer[] arr) {
					
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(6);
		
		return root;
	}
 
	public static void main(String[] args) {
		
		Integer[] arr = {22,-4,null,-60,null,-90};
		
		ValidateBinaryTree98 vl = new ValidateBinaryTree98();
		TreeNode root = vl.create(arr);

		System.out.println(vl.isValidBST(root));
	}

	
	public boolean isValidBST(TreeNode root) {
        
        if (root == null) return true;
        
        return isValidBST(root, root.val, null);
    }
    
    private boolean isValidBST(TreeNode root, int rootVal, Boolean fromLeft) {
        
        if (root == null) return true;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        int rt = root.val;
        if (left != null) {
            
            int l = left.val;
            
            if (l >= rt || (fromLeft != null && !fromLeft && l <= rootVal)) {
                
                return false;
            }
        }
        
        if (right != null) {
            
            int r = right.val;
            
            if (r <= rt || (fromLeft != null && fromLeft && r >= rootVal)) {
                
                return false;
            }
        }
        
        int t = 1000000000;
        
        return isValidBST(left, rootVal, fromLeft == null ? true : fromLeft) && isValidBST(right, rootVal,  fromLeft == null ? false : fromLeft);
    }
}
