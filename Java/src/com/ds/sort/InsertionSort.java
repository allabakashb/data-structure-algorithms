package com.ds.sort;

/**
 * 
 * @author Allabakash
 *
 */
public class InsertionSort implements Sorter{

	public InsertionSort() {
		System.out.println("******* InsertionSort *******");
	}
	
	/* 
	 * (non-Javadoc)
	 * @see com.ds.sort.Sorter#sort(int[])
	 */
	@Override
	public void sort(int[] array) {
		
		for (int i = 1; i < array.length; i++) {
			int num = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > num) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = num;
		}
		
	}

}


/*
* Time Complexity
*  O(n^2)
* 
* */