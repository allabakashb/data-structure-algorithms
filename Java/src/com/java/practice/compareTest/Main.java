package com.java.practice.compareTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Customer> list = new ArrayList<Customer>();
		list.add(new Customer("A", 34, 100));
		list.add(new Customer("H", 21, 187));
		list.add(new Customer("J", 10, 39));
		list.add(new Customer("B", 76, 123));
		list.add(new Customer("D", 55, 23));
		list.add(new Customer("C", 62, 86));
		
		System.out.println(list);
		
		Collections.sort(list);
		Collections.sort(list, new AgeComparator());
		
		System.out.println(list);
	}
}
