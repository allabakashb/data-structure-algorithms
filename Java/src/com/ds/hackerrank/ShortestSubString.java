package com.ds.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShortestSubString {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(shortestSubstring(br.readLine()));
	}

	public static int getMaxDistinctCharCount(String s, int length) {
		
		int numberOfDistinctCharacters = 256;
		int maxDistinctCount = 0;
		int count[] = new int[numberOfDistinctCharacters];
				
		for (int i = 0; i < length; i++) {
			
			count[s.charAt(i)]++;
		}
		
		for (int i = 0; i < numberOfDistinctCharacters; i++) {
			
			if (count[i] != 0) {
				maxDistinctCount++;
			}
		}
		
		return maxDistinctCount;
	}
	
	public static int shortestSubstring(String s) {
		 
		  int length = s.length();
		 
		  int minLength = length;
		  int maxDistinctCount = getMaxDistinctCharCount(s, length);
		  
		  for (int i = 0; i < length; i++) {
			  
			  for (int j = 0; j < length; j++) {
				  
				  String subStr = "";
				  if (i > j) {
					  
					  subStr = s.substring(j, i);
					  
				  } else {
					  
					  subStr = s.substring(i,  j);
				  }
				  
				  int subStrLength = subStr.length();
				  int subStrDistinctCount = getMaxDistinctCharCount(subStr, subStrLength);
				 
				  if (subStrLength < minLength && subStrDistinctCount == maxDistinctCount) {
					  
					  minLength = subStrLength;
				  }
			  }
		  }
		  
		  return minLength;
	 }
	
}
