package com.hackerrank.expedia;

import java.util.Scanner;

public class Solution2 {

	public static int longestVowelSubsequence(String s) {
	    
		int A=0, E=0,I=0,O=0,U=0,i=0;
		
		for(i=0;i<s.length();i++){
			if(s.charAt(i)=='a')
				break;
		}
		for(;i<s.length();i++){
			if(s.charAt(i)=='a')
				A++;
			else if(s.charAt(i)=='e')
				E=Math.max(A,E)+1;
			else if(s.charAt(i)=='i')
				I=Math.max(E,I)+1;
			else if(s.charAt(i)=='o')
				O=Math.max(I,O)+1;
			else if(s.charAt(i)=='u')
				U=Math.max(O,U)+1;
		}
		
		return U;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(longestVowelSubsequence(sc.next()));
		
		sc.close();
	}
}
