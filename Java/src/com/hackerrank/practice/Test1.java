package com.hackerrank.practice;

import java.util.Arrays;
import java.util.Comparator;

public class Test1 {

	public static void main(String[] args) {
		
		String[] c = { "b", "p", "s", "n" };
		
		Arrays.sort(c, new Mysort());
		System.out.println(Arrays.binarySearch(c, "n"));
	}

	static class Mysort implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			
			return o2.compareTo(o1);
		}
		
	}
}
