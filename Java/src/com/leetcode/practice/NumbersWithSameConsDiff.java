package com.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class NumbersWithSameConsDiff {

	public static void main(String[] args) {

		NumbersWithSameConsDiff nbr = new NumbersWithSameConsDiff();
		System.out.println(nbr.numsSameConsecDiff(3, 7));
	}

	public int[] numsSameConsecDiff(int N, int K) {

		List<Integer> list = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 9; i++) {
			backtrack(sb.append(i), N - 1, K, list);
			sb.deleteCharAt(0);
		}

		if (K == 0) {

			list.add(0);
		} else {

			int a = K;
			String ans = "";
			while (N-- > 0) {

				ans += a;
				a = a == K ? 0 : K;
			}
			list.add(Integer.parseInt(ans));
		}

		int[] result = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {

			result[i] = list.get(i);
		}

		return result;
	}

	private void backtrack(StringBuilder sb, int N, int K, List<Integer> list) {

		if (N <= 0) {
			list.add(Integer.parseInt(sb.toString()));
			return;
		}

		int prev = sb.charAt(sb.length() - 1);

		for (int i = 0; i <= 9; i++) {
			if (Math.abs(prev - i) == K) {
				backtrack(sb.append(i), N - 1, K, list);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

}
