package com.leetcode.practice;

public class Problem1262 {

	public int maxSumDivThree(int[] nums) {

		int n = nums.length;
		int dp[][] = new int[n][3];

		dp[0][nums[0] % 3] = nums[0];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {

				int num = dp[i - 1][j] + nums[i];

				int pos = num % 3;

				dp[i][pos] = Math.max(num, dp[i][pos]);

				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);

			}
		}

		return dp[n - 1][0];

	}
	
	public static void main(String[] args) {
		
		int[] input = { 3,6,5,1,8 };
		
		Problem1262 pp = new Problem1262();
		
		System.out.println(pp.maxSumDivThree(input));
		
		System.out.println(new StringBuilder().append((char)(12+'a')));
	}
}
