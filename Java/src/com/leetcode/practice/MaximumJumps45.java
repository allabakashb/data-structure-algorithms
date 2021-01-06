package com.leetcode.practice;

public class MaximumJumps45 {

	public int jump(int[] nums) {

		if (nums.length <= 1)
			return 0;

		int jumps = 0, i = 0;
		while (i < nums.length) {

			int steps = nums[i];

			if ((i + steps) >= (nums.length - 1)) {

				jumps++;
				break;
			}
			int min = Integer.MAX_VALUE, minIndex = i + steps;
			int j = i + 1;
			while (j <= (i + steps) && j < nums.length && min > 0) {

				int dist = nums.length - j - nums[j];

				if (min > dist) {

					min = dist;
					minIndex = j;
				}
				j++;
			}

			i = minIndex;
			jumps++;
		}

		return jumps;
	}

	public static void main(String[] args) {

		MaximumJumps45 p = new MaximumJumps45();
		int[] in = { 7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3 };
		System.out.println(p.jump(in));
	}

}
