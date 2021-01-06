package com.java.practice.ds;

import java.util.Scanner;

/*
 * 
 * Given a sorted array in which each element is repeated twice and one element is repeated thrice find thrice one element in O(log(n)) complexity.
Input : 2,2,3,3,4,4,6,6,8,8,9,9,9
 */
public class SortedArraySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(",");
		int[] input = new int[line.length];
		for (int i = 0; i < line.length; i++) {
			input[i] = Integer.parseInt(line[i]);
		}
		sc.close();
		System.out.println(new SortedArraySearch().find(input));
	}

	private int find(int[] arr) {
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = ((end - start) / 2) + start;
			if (mid < end && arr[mid] == arr[mid + 1]) {
				start = mid+1;
				if (mid > 0 && arr[mid] == arr[mid-1]) return arr[mid];
			} else {
				if (mid > 1 && arr[mid] == arr[mid-1] 
						&& arr[mid-1] == arr[mid-2]) return arr[mid];
				end = mid-1;
			}
		}
		return -1;
	}
}
