package com.ds.sort;

/**
 * @author Allabakash
 *
 */
public class QuickSort implements Sorter{

	@Override
	public void sort(int[] array) {
		
		doSort(array, 0, array.length - 1);
		
	}

	private void doSort(int[] array, int startIndex, int endIndex) {
		
		if (startIndex < endIndex) {
			
			int pi = partition(array, startIndex, endIndex);
			doSort(array, startIndex, pi - 1);
			doSort(array, pi, endIndex);
		}
	}
	
	private int partition(int[] array, int startIndex, int endIndex) {
		int pivot = array[endIndex];
		
		return pivot;
	}

}

/*
 * 
 * Time complexity - O(nlogn)
 * worst - O(n^2) 
 * 
 */