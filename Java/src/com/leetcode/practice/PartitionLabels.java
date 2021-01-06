package com.leetcode.practice;

import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		
		new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij").forEach(System.out::println);
	}

	public List<Integer> partitionLabels(String S) {

		int[] parts = new int[26];

		LinkedList<Integer> result = new LinkedList<>();

		for (int i = 0; i < S.length(); i++) {

			int index = S.charAt(i) - 'a';

			if (parts[index] == 0) {

				result.add(1);
				parts[index] = result.size();
			} else {

				if (result.size() > parts[index]) {
					while (result.size() > parts[index]) {
						result.addLast(result.removeLast() + result.removeLast());
					}
					for (int j = 0; j < 26; j++) {
						if (parts[j] > result.size()) {

							parts[j] = result.size();
						}
					}
				}

				result.addLast(result.removeLast() + 1);
			}
		}

		return result;
	}

}
