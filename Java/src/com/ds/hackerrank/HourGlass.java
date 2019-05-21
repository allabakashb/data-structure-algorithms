package com.ds.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HourGlass {

	public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int length = 6;
    	int[][] array = new int[length][length];
        for (int i = 0; i < 6; i++) {
        	
        	String[] arr = br.readLine().split(" ");
        	
        	for (int j = 0; j < length; j++) {
        		
        		array[i][j] = Integer.parseInt(arr[j]);
        	}
        }
        
        int sum = -63;
        for (int i = 0; i < (length - 2); i++) {
        	
        	for (int j = 0; j < (length - 2); j++) {
        		
        		int total = getSum(array, i, j);
        		
        		if (sum < total) {
        			
        			sum = total;
        		}
        	}
        }
        
        System.out.println(sum);
	}

	private static int getSum(int[][] array, int i, int j) {
		
		int sum = 0, count = 0;
		
		while (count < 3) {
			
			sum += array[i][j + count];
			sum += array[i+2][j + count];
			
			count++;
		}
		
		sum += array[i + 1][j + 1];
		
		return sum;
	}
}
