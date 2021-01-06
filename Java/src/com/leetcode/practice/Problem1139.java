package com.leetcode.practice;

public class Problem1139 {

	public int largest1BorderedSquare(int[][] grid) {

		int ones = 0, m = grid.length, n = grid[0].length;

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				if (grid[i][j] == 1)
					++ones;
			}
		}

		if (ones == 0)
			return 0;
		int maxSquare = Math.min(m, n);

		if (ones == m * n)
			return maxSquare * maxSquare;

		int largest = 1;

		for (int limit = 2; limit <= maxSquare; limit++) {

			int largestFound = largest;
			for (int row = 0; row <= m - limit; row++) {

				for (int col = 0; col <= n - limit; col++) {

					if (isValidSquare(grid, row, col, col + limit, row + limit)) {

						largestFound = limit;
						break;
					}
				}

				if (largestFound > largest) {
					largest = largestFound;
					break;
				}
			}
		}

		return largest * largest;
	}

	private boolean isValidSquare(int[][] grid, int row, int col, int colLimit, int rowLimit) {

		int i = row, j = col;

		// forward
		while (j < colLimit && grid[i][j] == 1) {
			++j;
		}

		if (j != colLimit)
			return false;

		--j; // downward
		while (i < rowLimit && grid[i][j] == 1) {
			++i;
		}

		if (i != rowLimit)
			return false;

		--i; // backward
		while (j >= col && grid[i][j] == 1) {
			--j;
		}

		if (j >= col)
			return false;

		++j; // upward

		while (i >= row && grid[i][j] == 1) {
			--i;
		}

		return i < row;
	}

	public static void main(String[] args) {

		int[][] input = {{0,1,1,1},{1,1,1,1},{1,0,0,1},{1,1,1,1},{1,0,1,1},{1,1,0,1}};

		System.out.println(new Problem1139().largest1BorderedSquare(input));
	}

}
