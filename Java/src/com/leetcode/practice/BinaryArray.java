package com.leetcode.practice;

public class BinaryArray {

	public int findMaxLength(int[] nums) {

		int ones = nums[0] == 0 ? 0 : 1, zeros = nums[0] == 0 ? 1 : 0, len = 1, maxLen = 0;
		for (int i = 1; i < nums.length; i++) {

			if (nums[i] == nums[i - 1]) {

				maxLen = Math.max(len, maxLen);
				len = 1;
			} else {
				++len;
			}

			if (i % 2 != 0)
				maxLen = Math.max(len, maxLen);

			if (nums[i] == 1) {

				++ones;
			} else {

				++zeros;
			}

			if (i % 2 != 0 && (ones == zeros)) {

				maxLen = Math.max(i + 1, maxLen);
			}
		}
		return ones == (nums.length / 2) && nums.length % 2 == 0 ? nums.length : maxLen;
	}

	public static void main(String[] args) {
		
		int[] nums = {1,0,1,1,0,1,1,0,0,1};
		System.out.println(new BinaryArray().findMaxLength(nums));

	}

}
