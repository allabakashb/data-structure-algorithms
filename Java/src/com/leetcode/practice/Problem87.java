package com.leetcode.practice;

public class Problem87 {

	public static void main(String[] args) {
		
		System.out.println(new Problem87().isScramble("great", "rgeat"));
	}

	public boolean isScramble(String s1, String s2) {
		char[] s1Arr = s1.toCharArray();
		char[] s2Arr = s2.toCharArray();

		for (int i = 0; i < s1Arr.length; i++) {

			if (backtrack(s1Arr, 0, i, s2Arr) || backtrack(swap(s1Arr, i, false), i + 1, s1Arr.length, s2Arr)) {

				return true;
			}
		}
		
		return false;
	}

	private boolean backtrack(char[] s1Arr, int start, int end, char[] s2Arr) {

		if (start >= end) {
			return areEqual(s1Arr, s2Arr);
		}

		for (int i = start; i < end; i++) {

			if (backtrack(s1Arr, start, i, s2Arr)) {

				return true;
			}
			
			swap(s1Arr, i, true);
			if (backtrack(s1Arr, i + 1, end, s2Arr)) {
				 
				 return true;
			}
		}

		return false;
	}

	private boolean areEqual(char[] s1Arr, char[] s2Arr) {

		for (int i = 0; i < s1Arr.length; i++) {

			if (s1Arr[i] != s2Arr[i])
				return false;
		}

		return true;
	}

	private char[] swap(char[] s1Arr, int mid, boolean update) {

		char[] newArr = new char[s1Arr.length];

		int j = 0;
		for (int k = mid + 1; k < s1Arr.length; k++) {
			newArr[j++] = s1Arr[k];
		}

		int i = s1Arr.length - mid - 1;
		j = 0;

		while (j <= mid) {

			newArr[i++] = s1Arr[j++];
		}
		
		if (update) {
			
			for (i = 0; i < s1Arr.length; i++) {
				
				s1Arr[i] = newArr[i];
			}
		}
		
		return newArr;
	}
}
