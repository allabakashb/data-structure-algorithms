package com.leetcode.practice;

import java.util.Scanner;

public class Problem6 {
	
	public String convert(String s, int numRows) {
        
		String[] nodes = new String[numRows];

		int index = 0; boolean dec = false;
		for (int i = 0; i < s.length(); i++) {
			
			if (nodes[index] == null) {
				nodes[index] = "";
			}
			nodes[index] += String.valueOf(s.charAt(i));
			
			if (index == numRows-1) {
				dec = true;
			} else if (index == 0){
				dec = false;
			}
			
			if (!dec && index < numRows - 1) {
				
				index++;
			} else if (index > 0) {
				
				index--;
			}
		}
		
		String result = "";
		
		for (String str: nodes) {
			result += str;
		}
		return result;
    }

	public static void main(String[] args) {

		Problem6 p = new Problem6();

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {

			System.out.println(p.convert(sc.next(), sc.nextInt()));
		}
		
		sc.close();
	}
}
