package com.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem1307 {

	public boolean isSolvable(String[] words, String result) {

		int[] chars = new int[26];

		Arrays.fill(chars, -1);

		List<Integer> charList = new ArrayList<>();
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				if (chars[word.charAt(i) - 'A'] == -1) {
					chars[word.charAt(i) - 'A'] = 0;
					charList.add(word.charAt(i) - 'A');
				}
			}
		}

		for (int i = 0; i < result.length(); i++) {
			if (chars[result.charAt(i) - 'A'] == -1) {
				chars[result.charAt(i) - 'A'] = 0;
				charList.add(result.charAt(i) - 'A');
			}
		}

		LinkedList<Integer> digits = new LinkedList<>();

		for (int i = 0; i < 10; i++)
			digits.add(i);

		return backtrack(words, result, chars, charList, 0, digits);
	}

	private boolean backtrack(String[] words, String result, int[] chars, List<Integer> charList, int index,
			LinkedList<Integer> digits) {

		if (index >= charList.size()) {

			return isSolvable(words, result, chars);
		}

		for (int i = 0; i < digits.size(); i++) {
			int digit = digits.removeFirst();
			chars[charList.get(index)] = digit;
			if (backtrack(words, result, chars, charList, index + 1, digits))
				return true;
			digits.addLast(digit);
		}

		return false;
	}

	private boolean isSolvable(String[] words, String result, int[] chars) {

		int sum = 0;

		for (String word : words) {

			sum += getSum(word, chars);
		}

		return sum == getSum(result, chars);
	}

	private int getSum(String str, int[] chars) {

		String sum = "";

		for (int i = 0; i < str.length(); i++) {

			if (i == 0 && chars[str.charAt(i) - 'A'] == 0)
				return Integer.MIN_VALUE;

			sum += chars[str.charAt(i) - 'A'];
		}

		return Integer.valueOf(sum);
	}

	public static void main(String[] args) {

		Problem1307 p7 = new Problem1307();
		String[] words = { "SIX","SEVEN","SEVEN" };
		String result = "TWENTY";
		System.out.println(p7.isSolvable(words, result));
	}

}
