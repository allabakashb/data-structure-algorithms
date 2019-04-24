package com.ds.sort;

/**
 * @author Allabakash
 *
 */
public class BubbleSort implements Sorter{

	public BubbleSort() {
		System.out.println("******* BubbleSort *******");
	}
	
	/* 
	 * (non-Javadoc)
	 * @see com.ds.sort.Sorter#sort(int[])
	 */
	@Override
	public void sort(int[] array) {
		boolean swapped = false;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
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
* Time Complexity
*  O(n^2)
* */