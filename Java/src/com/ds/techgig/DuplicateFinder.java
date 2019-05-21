package com.ds.techgig;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DuplicateFinder {

	public static void main(String args[] ) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int n = Integer.valueOf(br.readLine());
				int count = 0;

				int[] arr = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = Integer.valueOf(br.readLine());
				}
				
				arr = doSort(arr);
				
				int prev = arr[0]; boolean found = false;
				for (int i = 1; i < n; i++) {
					
					if (prev == arr[i]) {
						
						if (!found) {
							found = true;
							count++;
						}
						
					} else {
						
						found = false;
					}
					
					prev = arr[i];
				}
				
				System.out.println(count);
		   }
	
	private static int[] copyArray(int[] src, int startingIndex, int length) {
		
		int[] destination = new int[length];
		
		for (int i = 0; i < length; i++) {
			destination[i] = src[i + startingIndex];
		}
		
		return destination;
	}
	
	private static int[] doSort(int[] array) {
		int length = array.length;
		
		if (length < 2) {
			return array;
		}
		
		int mid = length / 2;
		int[] left = copyArray(array, 0, mid);
		int[] right = copyArray(array, mid, length - mid);
		
		left = doSort(left);
		right = doSort(right);
		
		return merge(left, right, array);
	}
	
	private static int[] merge(int[] left, int[] right, int[] array) {
		int leftLength = left.length, rightLength = right.length;
		
		int i = 0, j = 0, k = 0;
		
		while (i < leftLength && j < rightLength) {
			
			if (left[i] > right[j]) {
				
				array[k] = right[j];
				j++;
			} else {
				
				array[k] = left[i];
				i++;
			}
			
			k++;

		}
		
		while (i < leftLength) {
			array[k] = left[i];
			i++;
			k++;
		}
		
		while (j < rightLength) {
			array[k] = right[j];
			j++;
			k++;
		}
		
		return array;
	}
}
