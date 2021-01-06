package com.hackerearth.sept.circuit;

import java.util.Scanner;

public class Problem1 {

	private static final int MOD = 1000000007;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		sc.close();
		
		long ways = 1; 
		int fact = M;
		while (fact > 0) {
			
			ways *= fact;
			
			fact--;

			ways %= MOD;
		}
		
		//ways *= (N/M);
		System.out.println(ways % MOD);
	}

}
