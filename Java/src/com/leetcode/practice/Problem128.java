package com.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class Problem128 {

	public int longestConsecutive(int[] nums) {

		if (nums.length == 0)
			return 0;

		Map<Integer, Integer> map = new HashMap<>();

		int longest = 0;
		for (int n : nums) {
			if (!map.containsKey(n)) {

				Integer prev = map.get(n - 1);
				Integer next = map.get(n + 1);
				int curr = 1;

				if (prev != null) {

					curr += prev;
				}

				if (next != null) {

					curr += next;
				}

				if (prev != null) {

					map.put(n - 1, curr);
				}

				if (next != null) {

					map.put(n + 1, curr);
				}

				map.put(n, curr);

				longest = Math.max(longest, curr);
			}
		}

		return longest;
	}

	public static void main(String[] args) {

		Problem128 pp = new Problem128();
		System.out.println(pp.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
	}
}
