package com.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerfectSquares {

	public int numSquares(int n) {

		List<Integer> list = new ArrayList<>();

		for (int i = 1; (i * i) <= n; i++) {

			list.add(i * i);
		}

		Map<Integer, Integer> map = new HashMap<>();

		return getMinNums(list, n, map);
	}

	private int getMinNums(List<Integer> list, int sum, Map<Integer, Integer> map) {

		if (sum == 0) {

			return 0;
		}
		
		if (sum < 0) {
			
			return Integer.MAX_VALUE - 1;
		}

		if (map.containsKey(sum))
			return map.get(sum);

		int min = Integer.MAX_VALUE - 1;

		for (int i = 0; i < list.size(); i++) {

			min = Math.min(min, getMinNums(list, sum - list.get(i), map));
		}

		++min;
		
		map.put(sum, min);

		return min;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new PerfectSquares().numSquares(16));
	}
}
