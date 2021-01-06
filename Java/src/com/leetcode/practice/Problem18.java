package com.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18 {

	public static void main(String[] args) {
		
		int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
		int target = -9;
		
		new Problem18().fourSum(nums, target);
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> list = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {

			for (int j = 0; j < nums.length - 2; j++) {

				int start = j + 1, end = nums.length - 1;

				while (start < end) {

					int sum = nums[i] + nums[j] + nums[start] + nums[end];

					if (sum == target) {

						list.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));

						while (start < nums.length && nums[start] == nums[start + 1])
							++start;

						while (end > 0 && nums[end] == nums[end - 1])
							--end;

						++start;
						--end;

					} else if (sum > target) {

						--end;
					} else {

						++start;
					}
				}

				while (j < nums.length - 2 && nums[j] == nums[j + 1])
					++j;
			}

			while (i < nums.length - 3 && nums[i] == nums[i + 1])
				++i;
		}

		return list;
	}
}
