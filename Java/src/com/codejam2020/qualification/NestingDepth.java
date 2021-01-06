package com.codejam2020.qualification;

import java.util.Scanner;

public class NestingDepth {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);

		int t = sc.nextInt();
		
		int k = 0;
		
		while (k++ < t) {
			
			String digits = sc.next();
			
			StringBuilder raw = new StringBuilder();
			
			char[] array = digits.toCharArray();
			
			for (int i = 0; i < array.length; i++) {
								
				int n = Character.getNumericValue(array[i]);
				
				int j = 1;
				
				while (j <= n) {
					
					raw.append('(');
					++j;
				}
				
				raw.append(array[i]);
				
				j = 1;
				
				while (j <= n) {
					
					raw.append(')');
					++j;
				}
			}		
			
			String res = raw.toString().replace(")(", "");
			
			/*
			 * for (int i = 1; i < 10; i++) {
			 * 
			 * res = res.replace(")(", ""); }
			 */
			
			System.out.println(String.format("Case #%d: %s", k, res));
		}
		
		sc.close();
	}
}
