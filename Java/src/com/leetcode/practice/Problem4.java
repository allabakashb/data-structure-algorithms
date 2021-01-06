package com.leetcode.practice;

import java.util.Scanner;

public class Problem4 {
	

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
		if (nums1.length > nums2.length) {
			
			return findMedianSortedArrays(nums2, nums1);
		}
		
		int x = nums1.length, y = nums2.length;

		int low = 0, end = x;
		
		while (low <= end) {
			
			int partitionX = (low + end) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;
			
			int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];

			int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];
			
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				
				if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
			} else if (maxLeftX > minRightY) {
				
				end = partitionX - 1;
			} else {
				
				low = partitionX + 1;
			}
		}
		
		throw new IllegalArgumentException();
    }

	public static void main(String[] args) {
		
		Problem4 p4 = new Problem4();
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while (t-- > 0) {
			
			int len1 = sc.nextInt();
			int len2 = sc.nextInt();
			
			int[] array1 = new int[len1];
			int[] array2 = new int[len2];
			
			for (int i = 0; i < len1; i++) {
				array1[i] = sc.nextInt();
			}
			
			for (int i = 0; i < len2; i++) {
				array2[i] = sc.nextInt();
			}
			System.out.println(p4.findMedianSortedArrays(array1, array2));
		}
		
	}
}
