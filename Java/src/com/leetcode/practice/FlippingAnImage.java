package com.leetcode.practice;

public class FlippingAnImage {

	public int[][] flipAndInvertImage(int[][] A) {

		int m = A.length;
		int n = A[0].length;
		int[][] result = new int[m][n];

		int mid = n / 2;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < mid; j++) {
				int temp = A[i][j];
				result[i][j] = A[i][n - j - 1] ^ 1;
				result[i][n - j - 1] = temp ^ 1;
			}
		}

		if (mid % 2 != 0) {
			for (int i = 0; i < m; i++) {

				result[i][mid] = A[i][mid] ^ 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		FlippingAnImage fii = new FlippingAnImage();
		int[][] in = {{1,1,0},{1,0,1},{0,0,0}};
		fii.flipAndInvertImage(in);
	}

}
