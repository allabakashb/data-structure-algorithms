/**
 * 
 */
package com.ds.sort;

/**
 * @author Allabakash
 *
 */
public class SelectionSort implements Sorter {

	
	public SelectionSort() {
		System.out.println("******* SelectionSort *******");
	}
	
	/* 
	 * (non-Javadoc)
	 * @see com.ds.sort.Sorter#sort(int[])
	 */
	@Override
	public void sort(int[] array) {
		 
		boolean swapped = false;
		for (int i = 0; i < array.length - 1; i++) {
			
			for (int j = i + 1; j < array.length; j++) {
				
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					swapped = true;
				}
			}
			
			//Already sorted , no need to check other elements
			if (!swapped) {
				break;
			}
		}
	}
}

/*
* 
* Time Complexity
*  O(n^2)
* 
* */