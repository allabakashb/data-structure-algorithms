package com.leetcode.practice;

public class MultiplyStrings43 {

	public static void main(String[] args) {
	
		String num1 = "10";
		String num2 = "12";

		System.out.println();
	}

	private int getNumber(String str) {
		
		int prod = 0;
		for (int i = 0; i < str.length(); i++) {
			
			prod += (str.charAt(i) - '0') * Math.pow(10, str.length() - i - 1);
		}
		
		return prod;
	}
}
