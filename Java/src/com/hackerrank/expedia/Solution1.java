package com.hackerrank.expedia;

import java.util.Scanner;
import java.util.Stack;

public class Solution1 {

	static String[] braces(String[] values) {

		String[] result = new String[values.length];
				
		for (int i = 0; i < values.length; i++) {
			
			Stack<Character> st = new Stack<>();
			
			for (char ch: values[i].toCharArray()) {
				
				if (ch == '(' || ch == '{' || ch == '[') {
					
					st.push(ch);
				} else if (!st.isEmpty()){
					
					char popped = st.pop();
					
					if (!isMatched(ch, popped)) {
						
						st.push(ch);
						break;
					}
				} else {
					
					st.push(ch);
					break;
				}
			}
			
			result[i] = st.isEmpty() ? "YES" : "NO";
			
		}
		return result;
    }
	
	private static boolean isMatched(char start, char end) {
		
		boolean isMatched = false;
		
		if (start == '(' && end == ')') {
			
			isMatched = true;
		} else if (start == '{' && end == '}') {
			
			isMatched = true;
		} else if (start == '[' && end == ']') {
			
			isMatched = true;
		}
			
		return isMatched;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[] input = new String[n];
		for (int i= 0; i < n; i++) {
			input[i] = sc.next();
		}
		
		String[] result = braces(input);
		
		for (String t: result) {
			
			System.out.println(t);
		}
		
		sc.close();
	}
}
