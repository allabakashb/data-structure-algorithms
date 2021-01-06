package com.leetcode.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQTest {

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return o2.compareTo(o1);
			}
		});

		for (int i = 1; i <= 3; i++) {

			for (int j = 1; j <= 3; j++) {
				add(pq, i * j, 5);
			}
		}

		System.out.println(pq);

	}

	private static void add(PriorityQueue<Integer> pq, int element, int k) {

		if (pq.size() < k || pq.peek() >= element) {

			if (pq.size() >= k) {

				pq.remove();
			}

			pq.add(k);
		}
	}
}
