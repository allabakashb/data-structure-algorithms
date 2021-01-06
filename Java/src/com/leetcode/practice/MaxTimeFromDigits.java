package com.leetcode.practice;

import java.util.Arrays;

public class MaxTimeFromDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MaxTimeFromDigits mt = new MaxTimeFromDigits();
		System.out.println(mt.largestTimeFromDigits(new int[] {2, 0, 6, 6}));
	}

	public String largestTimeFromDigits(int[] A) {

		Integer[] arr = new Integer[A.length];

		for (int i = 0; i < A.length; i++) {
			arr[i] = A[i];
		}

		Arrays.sort(arr, (n1, n2) -> n2 - n1);

		for (int i = 0; i < arr.length; i++) {
			swap(arr, i, 0);
			if (arr[0] < 3) {
				String maxTime = backtrack(Arrays.copyOf(arr, arr.length), 1);
				if (maxTime.length() > 0) {
					return arr[0] + maxTime;
				}
			}
		}

		return "";
	}

	private void swap(Integer[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	private String backtrack(Integer[] A, int index) {

		if (index > A.length)
			return "";

		if (index == A.length - 1)
			return "" + A[index];

		String maxTime = "";

		int i = index, limit = (index == 1 && A[0] == 2) ? 4 : (index == 2 ? 6 : 10);
		while (i < A.length) {
			swap(A, i, index);
			if (A[index] < limit) {
				maxTime = backtrack(A, index + 1);
				if (maxTime.length() > 0) {
					break;
				}
			}
			++i;
		}

		if (maxTime.length() == 0)
			return maxTime;

		return A[index] + (index == 1 ? ":" : "") + maxTime;
	}

}
