package com.leetcode.weekly;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem3 {
    
	public int maxSumDivThree(int[] nums) {
        
		int maxSum = 0;
		
		Map<Integer, Integer> map= new HashMap<Integer,Integer>();
		
		int[] mod = new int[nums.length];
		int sum = 0;
		
		for (int i = 0; i < nums.length; i++) {
			
			sum += nums[i];
			
			mod[i] = ((sum % 3) + 3) % 3;
		}
		
		int max = 0;
		for (int i = 0; i < nums.length; i++) 
        { 
         
            if (mod[i] == 0) {
            	
            	max = i + 1; 
            	maxSum += nums[i];
            } else if (map.containsKey(mod[i]) == false) {
            	
            	map.put(mod[i] , i); 
            } else if (max <= (i - map.get(mod[i]))) {
            	
                max = i - map.get(mod[i]);
                maxSum += nums[i];
            }
                    
        } 
		
		return maxSum;
    }

	public static void main(String[] args) {
		
		Problem3 p = new Problem3();
		
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t-- > 0) {
			
			int n = sc.nextInt();
			
			int i =0;
			
			int[] a = new int[n];
			while (i < n) {
				a[i] = sc.nextInt();
				i++;
			}
			System.out.println(p.maxSumDivThree(a));
		}
		
		sc.close();

	}

}
