package com.ds.util;

import com.ds.exceptions.IncorrectArraySize;
import com.ds.exceptions.NoSuchType;
import com.ds.sort.BubbleSort;
import com.ds.sort.InsertionSort;
import com.ds.sort.MergeSort;
import com.ds.sort.SelectionSort;
import com.ds.sort.Sorter;

public class Test {
	
	public static void main(String[] args) {
		
		try {
			test("bs", 10);
			test("is", 10);
			test("ss", 10);
			test("ms", 101);
		} catch (IncorrectArraySize | NoSuchType e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void test(String type, int size) throws IncorrectArraySize, NoSuchType {
		Sorter sr = null;
		
		switch(type) {
			case "bs": 
				sr = new BubbleSort();
				break;
			case "is": 
				sr = new InsertionSort();
				break;
			case "ss": 
				sr = new SelectionSort();
				break;
			case "ms": 
				sr = new MergeSort();
				break;
			default:
				throw new NoSuchType(type);
		}
		
		int[] array = DSUtils.getRandomArray(size);
		sr.sort(array);
		DSUtils.printArray(array);
	}
}
