package com.leetcode.practice;

import java.util.Arrays;

public class BiggestNumber {

	public static void main(String[] args) {
		for (int i = 0; i< 10; i++) {
			
			int n = (int) (Math.random() * 10000 + 10000);
			
			System.out.println(n + " -> " + swapAndGetBiggestNumber(n));
		}
	}

	public static int swapAndGetBiggestNumber(int num) {
				
		char[] array = String.valueOf(num).toCharArray();
		
		int smallest = array.length-1, biggest = array.length-1;
		
		for (int i = array.length-2; i >= 0; i--) {
			
			if (array[i] > array[biggest] && i < biggest) {
				
				biggest = i;
			} else if (array[i] < array[biggest]) {
				
				smallest = i;
			}
		}
		
		char temp = array[smallest];
		array[smallest] = array[biggest];
		array[biggest] = temp;

		return Integer.parseInt(new String(array));
	}
}

/*
	1234
	9123
	9912
	9982
	9019
	9109
	9091
 * 
 */
