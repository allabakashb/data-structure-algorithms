package com.ds.skillenza;

import java.util.Scanner;

public class Solution {
	
	static int totalCost = 0;
	static int paths = 0;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			
			int n = sc.nextInt();
			
			String[][] matrix = new String[n][n];
			for (int j = 0; j < n; j++) {
				
				for (int k = 0; k < n; k++) {
					
					matrix[j][k] = sc.next();
					
				}
				
			}
			
			find(matrix, n);
			
			System.out.println(totalCost + " " + paths);
		}

	}

	private static void find(String[][] matrix, int n) {
				
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				
				findCost(matrix, i, j, n);
			}
		}
		
	}
	
	private static int findCost(String[][] matrix, int row, int col, int n) {
		
		if (col == n || row == n || matrix[row][col].equalsIgnoreCase("x")) {
			return -1;
		}
		
		if (col == n - 1) {
			
			String ct = matrix[row][col];
			
			
			return Integer.parseInt(matrix[row][col]);
		}
		
		if (matrix[row][col].equalsIgnoreCase("s")) {
			
			return 0;
		}
		
		//right
		int cost1 = findCost(matrix, row, col + 1, n);
		
		//bottom
		int cost2 = findCost(matrix, row + 1, col, n);
		
		//right diagonal
		int cost3 = findCost(matrix, row + 1, col + 1, n);
		
		if (row == 0) {
			int cost = 0, count = 0;
			if (cost1 > cost2) {
				
				cost = cost1;
				
			} else if (cost1 != -1) {
				
				if (cost1 == cost2) {
					count += 2;
					
				}
				
				cost = cost2;
			}
			
			if (cost > cost3) {
				
				cost = cost3;
				
			} else {
				
				if (cost == cost3) {
					
					count++;
				}
				
				if (count == 0) {
					
					count++;
					
				}
				
			}
			
			if (cost > totalCost) {
				
				totalCost = cost;
				
				paths = count;

			} else if (cost == totalCost) {
				
				paths += count;
			}
		} 
		
		return Integer.parseInt(matrix[row][col]);
		
	}

}
