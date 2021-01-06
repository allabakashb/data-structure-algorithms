package com.leetcode.practice;

import java.util.Scanner;

public class Problem8 {

	public int myAtoi(String str) {
        
		int len = str.length();
		int num = 0;
		if (len > 0) {
						
			String res = "";
			int i = 0; boolean found = false;
			int neg = 1;

			while ( i < len) {
				
				char c = str.charAt(i);
				
				if (c != '+' && c != '-' && c!= ' ' && Character.digit(c, 10) < 0)  break;
				
				if (c == ' ' && (res.length() > 0 || found)) break;
				
				if (c == '-' || c == '+') {
					
					if (found || res.length() > 0) break;
					
					if (c == '-') neg = -1;
					found = true;
				}
				
				res += c != '-' && c!= '+' && c != ' ' ? str.charAt(i) : "";
				i++;
			}
						
			if (!res.isEmpty()) {
			
				try {
					
					num = res.isEmpty() ? 0 : Integer.valueOf(res) * neg;
				} catch (NumberFormatException ex) {
					
					if (neg == -1) {
						
						num = Integer.MIN_VALUE;
					} else {
						
						num = Integer.MAX_VALUE;
					}
				}
			}
			
		}
		
		return num;
    }

	public static void main(String[] args) {
		
		Problem8 p = new Problem8();

		String[] str = {
				/*
				 * "42", "   -42", "4193 with words", "words and 987", "-91283472332", "      ",
				 * "+-8", "8+-8", "-+9",
				 * 
				 * "   +0 123",
				 */
			"  -0 451"
		};
		
		int i = 0;
		
		while (i < str.length) {
			System.out.println(p.myAtoi(str[i]));
			i++;
		}

	}

}
