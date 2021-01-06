package com.hackerearth.oct.circuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5 {
	
	static boolean prime[] = new boolean[100000000]; 
	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		sieveOfEratosthenes(100000001);
		while (t > 0) {
			
			int n = Integer.parseInt(br.readLine());
			
			String[] A = br.readLine().split(" ");
			
			int counter = 0;
			for (int i = 0; i < n; i++) {
				
				int Ai = Integer.parseInt(A[i]);
				
				counter += prime[Ai] ? 1 : 0;
			}
			
			System.out.println(counter);
			t--;
		}
	}
	
	static void sieveOfEratosthenes(int n) 
    { 
	
        for(int i=0;i<=n;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <n; p++) 
        { 
            
            if(prime[p] == true) 
            { 
                for(int i = p*p; i < n; i += p) 
                    prime[i] = false; 
            } 
        } 
        
    }
}
