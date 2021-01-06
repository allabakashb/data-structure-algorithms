package com.leetcode.practice;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1329 {

	public int[][] diagonalSort(int[][] mat) {

		for (int j = 0; j < mat[0].length; j++) {

			sortbyColumn(mat, j);
		}

		/*
		 * for (int i = 0; i < mat.length; i++) {
		 * 
		 * Arrays.sort(mat[i]); }
		 */

		return mat;
	}
	
	// Function to sort by column 
    public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    } 

	private void sortColumns(int[][] mat, int col) {

		Arrays.sort(mat, new Comparator<int[]>() {

			@Override
			public int compare(final int[] row1, final int[] row2) {

				if (row1[col] > row2[col]) {

					return 1;
				} else if (row1[col] < row2[col]) {

					return -1;
				}

				return 0;
			}
		});
	}

	public static void main(String[] args) {

		int[][] mat = { 
				{ 3, 3, 1, 1 }, 
				{ 2, 2, 1, 2 }, 
				{ 1, 1, 1, 2 } };

		Problem1329 p = new Problem1329();
		p.diagonalSort(mat);
	}
}
