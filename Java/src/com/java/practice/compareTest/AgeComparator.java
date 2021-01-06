package com.java.practice.compareTest;

import java.util.Comparator;

public class AgeComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer arg0, Customer arg1) {
		
		return arg0.getAge() > arg1.getAge() ? 1 : 
			( arg0.getAge() < arg1.getAge() ? -1 : 0);
	}

}
