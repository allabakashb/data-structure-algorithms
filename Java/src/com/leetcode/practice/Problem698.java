package com.leetcode.practice;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Problem698 {

	public boolean canPartitionKSubsets(int[] nums, int k) {

		if (nums.length < k)
			return false;

		int sum = 0;
		for (int n : nums) {
			sum += n;
		}

		if (sum % k != 0)
			return false;

		sum /= k;

		Arrays.sort(nums);
		Deque<Integer> deque = new LinkedList<>();

		for (int n : nums) {
			deque.addLast(n);
		}

		while (k-- > 1) {

			int currSum = 0;

			while (currSum < sum) {
				if ((currSum + deque.peekLast()) <= sum) {
					currSum += deque.removeLast();
				} else if ((currSum + deque.peekFirst()) <= sum) {
					currSum += deque.removeFirst();
				} else {
					return false;
				}
			}

			if (currSum != sum)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 3, 5, 2, 1 };
		int k = 4;
		System.out.println(new Problem698().canPartitionKSubsets(nums, k));
	}

}
