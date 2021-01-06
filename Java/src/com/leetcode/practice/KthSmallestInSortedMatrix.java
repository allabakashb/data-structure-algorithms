package com.leetcode.practice;

import java.util.Scanner;

public class KthSmallestInSortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {
        
		int row = 0, col = 1;
		int smallest = matrix[0][0];
		while (k > 0) {
			
			if (matrix[row][col] <= smallest) {
				
				col++;
			} else {
				
				row++;
			}
			
			k--;
		}
		
		return matrix[row][col];
    }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] matrix = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				
				matrix[i][j] = sc.nextInt();
			}
		}
		KthSmallestInSortedMatrix ks = new KthSmallestInSortedMatrix();
		System.out.println(ks.kthSmallest(matrix, k));
		sc.close();
	}

}
