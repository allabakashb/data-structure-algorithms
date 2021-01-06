package com.java.practice.java8;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Streams {

	public static void main(String[] args) {
		
		int[] numbers = {3, 9, 2, 5, 8, 1, 8, 9};
		
		IntPredicate predicate = new IntPredicate() {
			
			@Override
			public boolean test(int value) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		IntStream.of(numbers).filter(predicate);
		

	}

}
