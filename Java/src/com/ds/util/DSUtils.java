package com.ds.util;

import com.ds.exceptions.IncorrectArraySize;

public class DSUtils {

	public static int[] getRandomArray(int size) throws IncorrectArraySize {
		
		if (size < 0) {
			throw new IncorrectArraySize();
		}
		
		int[] array = new int[size];
		
		for (int i = 0; i < size; i++) {
			array[i] = (int) Math.ceil(Math.random() * 100);
		}
		
		printArray(array);
		
		return array;
	}
	
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + (i < array.length - 1 ? "," : ""));
		}
		System.out.println("");
	}
}
