package com.ds.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayManipulation {

	public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] nm = br.readLine().split(" ");
    	
    	int n = Integer.parseInt(nm[0]);
    	int m = Integer.parseInt(nm[1]);
    	
    	int[][] q = new int[m][3];

        for (int i = 0; i < m; i++) {
        	        	
        	String[] arr = br.readLine().split(" ");
        	
        	for (int k = 0; k < 3; k++) {
        		q[i][k] = Integer.valueOf(arr[k]);
        	}
        	
        }
        
        System.out.println(arrayManipulation(n, q));
	}
	
	static long arrayManipulation(int n, int[][] queries) {

		long maxSum = 0;
		long[] matrix = new long[n * n];
		
		for (int i = 0; i < queries.length; i++) {
			
			int lower = queries[i][0] - 1;
			int upper = queries[i][1];
			int value = queries[i][2];
			
			for (int k = lower; k < upper; k++) {
				
				for (int j = lower; j < upper; j++) {
					
					matrix[k + j] += value;
					
					if (matrix[k + j] > maxSum) {
						maxSum = matrix[k + j];
					}
				}
			}
		}
		return maxSum;
    }
	
}

//https://www.hackerrank.com/challenges/crush/problem
