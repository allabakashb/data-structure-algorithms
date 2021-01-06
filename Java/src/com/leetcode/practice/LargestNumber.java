package com.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {

	public String largestNumber(int[] nums) {

		List<String> list = new ArrayList<>();
		int total = 0;
		for (int n : nums) {
			list.add(String.valueOf(n));
			total += n;
		}

		if (total == 0)
			return "0";

		Collections.sort(list, (n1, n2) -> {
			int len = Math.min(n1.length(), n2.length());
			for (int i = 0; i < len; i++) {
				if (n1.charAt(i) != n2.charAt(i)) {
					return n2.compareTo(n1);
				}
			}

			if (n2.length() > n1.length()) {
				return n2.charAt(n1.length()) < n2.charAt(n1.length() - 1) ? -1 : 1;
			} else if (n2.length() < n1.length()) {
				return n1.charAt(n2.length()) < n1.charAt(n2.length() - 1) ? -1 : 1;
			}

			return 0;
		});

		StringBuilder sb = new StringBuilder();

		for (String s : list) {
			sb.append(s);
		}

		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println(new LargestNumber().largestNumber(new int[] { 824,938,1399,5607,6973,5703,9609,4398,8247 }));
	}
}
