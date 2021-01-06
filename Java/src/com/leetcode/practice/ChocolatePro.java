package com.leetcode.practice;

import java.util.Scanner;

public class ChocolatePro {

	public static void main(String args[] ) throws Exception {

	      Scanner sc = new Scanner(System.in);

	      int t = sc.nextInt();

	      while (t-- > 0) {

	         int n = sc.nextInt();
	         	         
	         int low = n % 2 == 0 ? n - 3 : n-2, high = n, maxSum = 0;
	         for (int i = 0; i < n/2; i++) {
	        	 
	        	 maxSum += Math.abs(low - high); //3 5 1 4 2
	        	 low--;
	        	 high--;
	         }
	         
	         if (high != n-1)
	          maxSum += Math.abs(low - (high + 1)) + Math.abs(low - n);
	         else 
	          maxSum += Math.abs(low-(high-1));

	         System.out.println(n == 1 ? 1 : maxSum);
	      }

	   }
}
