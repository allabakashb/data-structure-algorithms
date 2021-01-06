package com.leetcode.practice;

public class Problem1457 {

	public static void main(String[] args) {
		Integer[] arr = { 2,3,1,3,1,null,1 };
		System.out.println(new Problem1457().pseudoPalindromicPaths(TreeNodeUtils.create(arr)));
	}

	public int pseudoPalindromicPaths (TreeNode root) {
        return countPaths(root, 1, new int[11]);
    }
    
	private int countPaths(TreeNode root, int len, int[] count) {
        if (root == null) {
            return 0;
        }
        
        ++count[root.val];
        
        if (root.left == null && root.right == null) {
        	boolean odd = false;
        	int val = 1;
            for (int i = 1; i < count.length; i++) {
                if (count[i] % 2 != 0) {
                    if (odd) {
                    	val = 0;
                    	break;
                    }
                    odd = true;
                }
            }
            --count[root.val];
            return val;
        }
        
        int left = countPaths(root.left, len+1, count);
        int right = countPaths(root.right, len+1, count);
        
        --count[root.val];
        
        return left + right;
    }
}
