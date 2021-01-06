package com.leetcode.practice;

public class RotateImage48 {

	public void rotate(int[][] matrix) {

		int n = matrix.length;

		int i = 0, start = 0;
		while (n - start >= 2) {

			int rowIndex = i;
			int len = n - start;
			for (int j = start; j < len - 1; j++) {

				int num = matrix[i][j];

				int row = rowIndex, col = len - 1;
				int k = 0;
				while (k < 3) {

					int temp = matrix[row][col];
					matrix[row][col] = num;
					num = temp;

					if (k == 0) {

						col = len - j - 1 + start;
						row = len - 1;
					} else if (k == 1) {

						col = start;
						row = len - j - 1 + start;
					}
					k++;
				}

				matrix[i][j] = num;
				rowIndex++;
			}

			start += 1;
			i = start;
		}
	}

	public static void main(String[] args) {

		int n = 3, count = 1;
		int[][] matrix = new int[n][n];
		int[][] clone = new int[n][n];
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

				matrix[i][j] = count++;
				clone[i][j] = matrix[i][j];
			}
		}
		RotateImage48 im = new RotateImage48();
		im.print(matrix);
		im.rotate(matrix);
		im.print(matrix);
		im.expected(clone);
	}

	public void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix.length; j++) {

				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public void expected(int[][] matrix) {
		
		int n = matrix.length;
		int[][] newMatrix = new int[n][n];
		
		int row = 0, col = n - 1;
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				newMatrix[row][col] = matrix[i][j];
				row++;
			}
			
			row = 0;
			col--;
		}
		
		print(newMatrix);
	}
}
