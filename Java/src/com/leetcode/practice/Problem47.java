package com.leetcode.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem47 {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3, 1, 2, 3};
		
		System.out.println(new Problem47().permuteUnique(nums));;
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteUnique(0, nums, res, new HashSet<>());
        return res;
    }
    
    private void permuteUnique(int index, int[] nums, List<List<Integer>> res, Set<Integer> set) {
        
        if (index >= nums.length) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int n: nums) {
                list.add(n);
            }
            int hash = list.hashCode();
            if (!set.contains(hash)) {
                set.add(hash);
                res.add(list);
            }
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            swap(nums, i, index);
            permuteUnique(i+1, nums, res, set);
            swap(nums, i, index);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
