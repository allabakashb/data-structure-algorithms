package com.ds.sort;

/**
 * @author Allabakash
 *
 */
public class MergeSort implements Sorter {

	public MergeSort() {
		System.out.println("******* MergeSort *******");
	}
	
	/* (non-Javadoc)
	 * @see com.ds.sort.Sorter#sort(int[])
	 */
	@Override
	public void sort(int[] array) {
		doSort(array);
	}
	
	
	/**
	 * @param src
	 * @param startingIndex
	 * @param endIndex
	 * @return
	 */
	private int[] copyArray(int[] src, int startingIndex, int length) {
		
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
	private int[] doSort(int[] array) {
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
	private int[] merge(int[] left, int[] right, int[] array) {
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

/*
 * Time Complexity
 *  O(nlogn)
 *
 */