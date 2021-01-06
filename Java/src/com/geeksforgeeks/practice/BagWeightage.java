package com.geeksforgeeks.practice;

import java.util.Scanner;

public class BagWeightage {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] wts = new int[N];
		for (int i = 0; i < N; i++) {
			wts[i] = sc.nextInt();
		}
		System.out.println(findMinCostWeight(wts, N, W));
	}

	private static char[] findMinCostWeight(int[] wts, int n, int w) {
		
		int[][] matrix = new int[n+1][n+1];
		
		for (int i = 0; i < (n+1); i++) {
			
			matrix[0][i] = Integer.MAX_VALUE;
			matrix[i][1] = 0;
		}
		return null;
	}

}


// https://www.geeksforgeeks.org/minimum-cost-to-fill-given-weight-in-a-bag/