package com.hackerearth.oct.circuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem4 {
	
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
		
		Map<Integer,Integer> map = new HashMap<>();
		
		int counter = 1, previousDiff = -1;
		for (int k = 1; k < n; k++) {
			
			int d = array[k] - array[k-1];
			
			if (previousDiff < 0) {
				
				previousDiff = d;
				counter++;
				
			} else {
				
				if ( d != previousDiff) {
					
					counter = 1;
					previousDiff = d;
				} else {
					
					counter++;
				}
				
			}
			
			Integer cnt = map.get(d);
			if (cnt == null || cnt < counter) {
				
				map.put(d, counter);
			}
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
			
			System.out.println(map.get(d));
		}
	}
}
