package com.hackerearth.practice;

import java.util.Scanner;

public class JamesCities {
	
	private static final int mod = 1000000007;

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
        	
        	long n = sc.nextLong();
        	
        	System.out.println(combinations(n));
        }

	}

	private static double combinations(long n) {
		
		if (n == 1) {
			
			return 1;
		}
				
		return (power(n) % mod)-1;
	}

	private static long power(long pow) {
		
		long ans = 1;
		long b = 2;
		while (pow > 0) {
			
			if((pow&1) == 1)
				ans=(ans*b)%mod;
			
				b=(b*b)%mod;
				pow>>=1;
		}
		
		return ans % mod;
	}
}
