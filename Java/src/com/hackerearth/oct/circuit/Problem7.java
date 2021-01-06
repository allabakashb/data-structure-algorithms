package com.hackerearth.oct.circuit;

import java.util.Scanner;

public class Problem7 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if (k > n) {
			
			System.out.println("No");
		} else {
			System.out.println("Yes");
			System.out.print(1 +" ");
		}
		sc.close();
	}
}
