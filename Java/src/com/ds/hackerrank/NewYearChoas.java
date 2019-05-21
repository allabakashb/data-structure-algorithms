package com.ds.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NewYearChoas {

	public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int t = Integer.parseInt(br.readLine());
    	
        for (int i = 0; i < t; i++) {
        	
        	int n = Integer.parseInt(br.readLine());
        	
        	String[] arr = br.readLine().split(" ");
        	int[] q = new int[n];
        	
        	for (int k = 0; k < n; k++) {
        		q[k] = Integer.valueOf(arr[k]);
        	}
        	
        	minimumBribes(q);
        }
        
	}
	
	static void minimumBribes(int[] q) {
			
		int minBribes = 0, start = q.length - 1;
		
		for (int i = start; i > -1; i--) {
			
			int index = i + 1;
			if (index != q[i]) {
				
				if (i > 2 && index != q[i - 1] && index != q[i - 2]) {
					
					minBribes = -1;
					break;
				}
				
				if (i > 0) {
					
					if (q[i - 1] == index) {
						
						int swap = q[i - 1];
						q[i - 1] = q[i];
						q[i] = swap;
						
						minBribes++;
					} else if (i > 1) {
						
						q[i - 2] = q[i - 1];
						q[i - 1] = q[i];
						q[i] = index;
						
						minBribes += 2;
					}
				}
				
			}
			
		}

		if (minBribes == -1) {
			
			System.out.println("Too chaotic");
		} else {
			System.out.println(minBribes);
		}
    }
}
