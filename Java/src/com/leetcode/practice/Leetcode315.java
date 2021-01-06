package com.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode315 {

public List<Integer> countSmaller(int[] nums) {
        
        List<Integer> result = new ArrayList<>(nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        
        new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2.compareTo(o1);
			}
		}).poll();
        
        for (int i = 0; i < nums.length; i++) {
            
            map.put(nums[i], i);
            result.add(0);
        }
        
        mergeSort(nums, result, map);
        
        return result;
    }
    
    private void mergeSort(int[] nums, 
                          List<Integer> result,
                          Map<Integer, Integer> map) {
        
       if (nums.length == 1) return;
        
       int mid = nums.length/2;
        
       int[] left = Arrays.copyOfRange(nums, 0, mid);
       int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        
        mergeSort(left, result, map);
        mergeSort(right, result, map);
        
       merge(nums, left, right, result, map);
    }
    
    private void merge(int[] nums, 
                       int[] left,
                       int[] right,
                       List<Integer> result,
                       Map<Integer, Integer> map) {
        
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            
            if (left[i] < right[j]) {
                
                nums[k++] = left[i++];
                
            } else {
                
                nums[k++] = right[j++];
                int index = map.get(left[i]);
                result.set(index, result.get(index)+1);
            }
        }
        
        while (i < left.length) {
            nums[k++] = left[i++];
            
            if (left.length != 1) {
            	
            	int index = map.get(left[i-1]);
                result.set(index, result.get(index)+1);
            }
        }
        
        while (j < right.length) {
            nums[k++] = right[j++];
        }
    }
    
    public static void main(String[] args) {
		
    	Leetcode315 lc = new Leetcode315();
    	lc.countSmaller(new int[] {2,7,1,5,8,9,4,3}).forEach(System.out::println);
	}
}
