package com.leetcode.practice;

public class SplitArrayEqualSumBruteForce {

	public boolean canPartition(int[] nums) {

		boolean[] visited = new boolean[nums.length];

		for (int i = 0; i < nums.length; i++) {

			visited[i] = true;
			if (canPartition(nums, visited, i, nums[i])) {

				return true;
			}
			visited[i] = false;
		}

		return false;
	}

	private boolean canPartition(int[] nums, boolean[] visited, int index, int sum) {

		if (index >= nums.length)
			return false;

		int currentSum = 0;
		for (int i = 0; i < nums.length; i++) {

			if (!visited[i]) {

				currentSum += nums[i];
			}
		}

		if (sum == currentSum) {
			
			int i = 0;
			
			while (i < nums.length) {
				
				if (visited[i]) {
					
					System.out.print(nums[i] + " ");
				}
				++i;
			}
			
			return true;
		}
		
		for (int i = 0; i < nums.length; i++) {

			if (!visited[i]) {

				visited[i] = true;

				if (canPartition(nums, visited, i, nums[i] + sum)) {

					return true;
				}

				visited[i] = false;
			}

		}

		return false;
	}

	public static void main(String[] args) {
		
		SplitArrayEqualSumBruteForce sbf = new SplitArrayEqualSumBruteForce();

		System.out.println(sbf.canPartition(new int[] {28,63,95,30,39,16,36,44,37,100,61,73,32,71,100,2,37,60,23,71,53}));
	}

}
