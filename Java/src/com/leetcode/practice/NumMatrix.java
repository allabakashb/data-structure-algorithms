package com.leetcode.practice;

import java.util.Arrays;
import java.util.Comparator;

public class NumMatrix {

	int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        
        int m = matrix.length, n = matrix[0].length;
        
        sumMatrix = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    sumMatrix[i][j] = matrix[i][j];
                } else {
                    sumMatrix[i][j] = matrix[i][j] + sumMatrix[i][j-1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            
            sum += sumMatrix[i][col2] - (col1 > 0 ? sumMatrix[i][col1-1] : 0);
        }
        
        return sum = 0;
    }
    
	public static void main(String[] args) {
		
		

	}

}
