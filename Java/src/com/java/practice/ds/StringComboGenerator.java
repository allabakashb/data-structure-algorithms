package com.java.practice.ds;

import java.util.Scanner;

public class StringComboGenerator {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[][] matrix = new String[4][4];
		for (int i = 0; i < 4; i++) {
			
			matrix[i] = sc.next().split("");	
		}

		
		for (int i = 0; i < 4; i++) {
			
			for (int  j = 0; j < 4; j++) {
				
				traverseString(matrix, i, j, matrix[i][j]);
			}
		}
	}

	private static void traverseString(String[][] matrix, int i, int j, String str) {
		
		if (str.length() > 1) {
			
			System.out.println(str);
		}
		
		if (j < 3) {
			
			traverseString(matrix, i, j+1, str.concat(matrix[i][j+1]));
		}
		
		if (i < 3 && j < 3) {
			
			traverseString(matrix, i+1, j+1, str.concat(matrix[i+1][j+1]));
		}
		
		if (i < 3) {
			
			traverseString(matrix, i+1, j, str.concat(matrix[i+1][j]));
		}
	}

}
