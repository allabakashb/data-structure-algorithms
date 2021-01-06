package com.leetcode.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LetterCombinationsOfPhoneNumber {

	final char[][] chars = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public List<String> letterCombinations(String digits) {

		List<String> li = new LinkedList<>();

		if (digits == null || digits.length() == 0)
			return li;

		backtrack("", digits, li);

		return li;
	}

	private void backtrack(String str, String digits, List<String> li) {

		if (digits.isEmpty()) {
			li.add(str);
			return;
		}
		char[] cs = chars[digits.charAt(0) - '2'];

		for (char c : cs)
			backtrack(str + c, digits.substring(1), li);
	}

	public static void main(String[] args) {

		LetterCombinationsOfPhoneNumber lp = new LetterCombinationsOfPhoneNumber();

		Scanner sc = new Scanner(System.in);

		List<String> li = lp.letterCombinations(sc.next());
		li.forEach(System.out::println);

		sc.close();
	}

}
