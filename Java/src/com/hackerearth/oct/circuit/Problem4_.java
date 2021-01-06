package com.hackerearth.oct.circuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4_ {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line1 = br.readLine().split(" ");
		
		int n = Integer.parseInt(line1[0]);
		int q = Integer.parseInt(line1[1]);
		
		String[] line2 = br.readLine().split(" ");
		int[] array = new int[n];
		
		for (int i = 0; i < n; i++) {
			
			array[i] = Integer.parseInt(line2[i]);
		}
		
		for (int j = 0; j < q; j++) {
			
			String[] line3 = br.readLine().split(" ");
			int l = Integer.parseInt(line3[0]);
			int r = Integer.parseInt(line3[1]);
			int d = Integer.parseInt(line3[2]);
			
			if (l == r) {
				
				System.out.println(1);
				continue;
			}
			
			int maxLen = 0, count = -1;
			for (int i = l; i < r; i++) {
				
				if (array[i] - array[i-1] == d) {
					
					if (count == -1) {
						
						count = 1;
					}
					
					count++;
				} else {
					
					count = -1;
				}
				
				if (maxLen < count) {
					
					maxLen = count;
				}
			}
			
			System.out.println(maxLen);
		}
	}
}
