package com.ds.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SocksPair {

	
	/**
	 * @param src
	 * @param startingIndex
	 * @param endIndex
	 * @return
	 */
	private static int[] copyArray(int[] src, int startingIndex, int length) {
		
		int[] destination = new int[length];
		
		for (int i = 0; i < length; i++) {
			destination[i] = src[i + startingIndex];
		}
		
		return destination;
	}
	
	/**
	 * @param array
	 * @return
	 */
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
	
	/**
	 * @param left
	 * @param right
	 * @param array
	 * @return
	 */
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
	
	// Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
    	ar = doSort(ar);
    	int count = 0, i = 0;
    	
    	while (i < n) {
    		int current = i;
    		int next = ++i;
    		++i;
    		
    		if (current < n && next < n) {
    			if (ar[current] == ar[next]) {
    				count++;
    			} else {
    				--i;
    			}
    		}
    	}
    	return count;
    }


    public static void main(String[] args) throws Exception {

    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
        int n = Integer.parseInt(br.readLine());

        int[] ar = new int[n];

        String[] arItems = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

       System.out.println(result);

    }
    
}
