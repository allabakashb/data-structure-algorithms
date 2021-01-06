package com.leetcode.practice;

public class CharacterRotate {

	
	public static void main(String[] args) {
				
		for (char ch = 'a'; ch <= 'z'; ch++) {
			
			int index = (ch-3);
			
			if (index < 'a') {
				index += 26;
			}
			System.out.println((char)index);
		}
	}

}
