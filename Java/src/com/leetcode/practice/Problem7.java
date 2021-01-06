package com.leetcode.practice;

import java.util.Scanner;

public class Problem7 {

	public int reverse(int x) {
        
		int y = 0;
		
		int pow = 1;
		while (x != 0) {
			
			int rem = x % 10;
			
			double temp = (int) (Math.pow(10, pow) * y + rem);
			
			if (temp > Integer.MIN_VALUE && temp < Integer.MAX_VALUE) {
				
				y = (int) temp;
			} else {
				
				y = 0;
				break;
			}
			x = x / 10;
		}
		
		return y;
    }

	public static void main(String[] args) {
		
		Problem7 p = new Problem7();
		
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t-- > 0) {
			System.out.println(p.reverse(sc.nextInt()));
		}
		
		sc.close();
	}

}
