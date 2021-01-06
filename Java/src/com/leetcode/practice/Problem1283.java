package com.leetcode.practice;

public class Problem1283 {

	public static void main(String[] args) {
		
		System.out.println(new Problem1283().smallestDivisor(new int[] { 1, 2, 5, 9 }, 6));
	}

	public int smallestDivisor(int[] nums, int threshold) {

		int maxDiv = (int) Math.pow(10, 6);

		if (maxDiv <= 1)
			return maxDiv;

		int start = 1, result = 1, prevSum = 0;
		while (start <= maxDiv) {

			int mid = (maxDiv + start) / 2;

			int sum = getSum(nums, (float) mid);

			if (sum > threshold) {
				start = mid + 1;
			} else {
				if (prevSum == sum) {
					result = Math.min(result, mid);
				} else {
					result = mid;
				}
				prevSum = sum;
				maxDiv = mid - 1;
			}
		}

		return result;
	}

	private int getSum(int[] nums, float div) {

		int sum = 0;

		for (int n : nums) {

			sum += (int) Math.ceil((float) n / div);
		}

		return sum;
	}

}
