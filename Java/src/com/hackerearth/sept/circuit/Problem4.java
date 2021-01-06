package com.hackerearth.sept.circuit;

import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int s1 = sc.nextInt();
		int s2 = sc.nextInt();
		int s3 = sc.nextInt();
		
		String s11 = sc.next();
		String x = sc.next();
		String s13 = sc.next();
		
		sc.close(); 
		char origMin = s13.charAt(0);
		char c2 = origMin;
		
		String str = "", smallest = "";
		for (int i = s2-1; i >= 0; i--) {
			
			char c = x.charAt(i);
			
			if (c <= c2 && c < origMin) {
				
				str = x.substring(i, i+1).concat(str);
				c2 = c;
			} else {
				
				str = "";
			}
		}
		
		System.out.println(s11 + str + s13);
	}

}
