package com.ds.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotateLeft {

	public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] line = br.readLine().split(" ");
    	int n = Integer.parseInt(line[0]);
    	int d = Integer.parseInt(line[1]);
    	
    	String[] arr = br.readLine().split(" ");
    	
    	int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
        	
        	numbers[i] = Integer.parseInt(arr[i]);
        }
        
        int[] a = rotLeft(numbers, d);
        
        for (int i = 0; i < a.length; i++) {
        	System.out.print(a[i] + " ");
        }
	}
	
	static int[] rotLeft(int[] a, int d) {
		
		int[] rotatedArray = new int[a.length];
		
		boolean done = false;
		int i = d, j = 0;
		
		while (!done) {
			
			if ((j + i) < a.length) {
				
				rotatedArray[j] = a[j + i];
				
				j++;
				
			} else {
				done = true;
			}
		}
		
		int k = 0;
		while (k < i) {
			
			rotatedArray[j] = a[k];
			j++;
			k++;
		}
		
		return rotatedArray;

    }
}
