package com.leetcode.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem1394 {

	public int findLucky(int[] arr) {

		if (arr.length == 0)
			return -1;

		Map<Integer, Integer> map = new HashMap<>();

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return o2.compareTo(o1);
			}
		});

		int largest = -1;
		for (int i = 0; i < arr.length; i++) {

			int count = map.getOrDefault(arr[i], 0) + 1;

			map.put(arr[i], count);

			if (count == arr[i]) {

				pq.add(arr[i]);
				largest = Math.max(largest, arr[i]);
			}

			if (largest == arr[i] && arr[i] != count) {

				pq.poll();
			}
		}
		
		return pq.size() > 0 ? pq.poll() : -1;
	}

	public static void main(String[] args) {

		Problem1394 pb = new Problem1394();

		int[] arr = { 3, 19, 18, 2, 9, 4, 7, 11, 15, 7, 14, 10, 11, 9, 8, 5, 4, 14, 11, 4, 16, 3, 13, 14, 14, 15, 8, 19,
				3, 5, 20, 15, 14, 10, 16, 11, 17, 20, 11, 20, 15, 3, 20, 5, 12, 2, 15, 12, 14, 16, 20, 17, 15, 8, 18, 9,
				8, 5, 12, 3, 5, 15, 14, 10, 2, 20, 20, 3, 13, 9, 1, 3, 16, 18, 14, 16, 13, 9, 18, 13, 9, 3, 5, 19 };
		System.out.println(pb.findLucky(arr));
		
		new HashMap<Integer,Integer>().entrySet();
	}
}
