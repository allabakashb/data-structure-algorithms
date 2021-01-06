package com.hackerearth.oct.circuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while (t > 0) {
			
			int n = Integer.parseInt(br.readLine());
			
			int sum = n * n-(n *(n+1)/2);
			
			int fact = 1;
			while (n > 1) {
				
				fact *= n;
				n--;
			}
			
			System.out.println(sum * fact);
			t--;
		}
	}
}
