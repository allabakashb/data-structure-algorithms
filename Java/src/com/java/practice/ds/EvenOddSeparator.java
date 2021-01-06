package com.java.practice.ds;

import java.util.Arrays;

public class EvenOddSeparator {
	
	public static int[] getRandomArray(int size) {
		
		int[] newArray = new int[size];
		
		for (int i = 0; i < size; i++) {
			
			newArray[i] = (int) (Math.random() * 100);
		}
		return newArray;
	}

	public static void main(String[] args) {
		
		int[] array = getRandomArray(1000000);
		
		Arrays.stream(array).forEach((e) -> System.out.print(e + " "));

//		Stopwatch st = new Stopwatch();
//		st.start();
//		seggregateEvenOddNumbers(array);
//		st.stop();
//		System.out.println("");
//		Arrays.stream(array).forEach((e) -> System.out.print(e + " "));
//		System.out.println("");
//		System.out.println(st.elapsedMillis() / 1000);

	}

	private static void seggregateEvenOddNumbers(int[] array) {
		
		int i = 0, j = array.length - 1;
		
		while (i != j && i < array.length && j > -1) {
			
			if (array[i] % 2 != 0) {
				
				while (i != j && i < array.length && j > -1) {
					
					if (array[j] % 2 == 0) {
						
						int swap = array[i];
						array[i] = array[j];
						array[j] = swap;
						j--;
						
						break;
					}
					j--;

				}
			} 
			
			i++;
		}
	}

}
