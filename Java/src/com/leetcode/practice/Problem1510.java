package com.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class Problem1510 {

	public boolean winnerSquareGame(int n) {

		return play(n, false, new HashMap<>());
	}

	private boolean play(int n, boolean alice, Map<Integer, Boolean> dp) {

		if (n == 0)
			return alice;

		if (dp.containsKey(n))
			return dp.get(n);

		int i = 1;
		boolean ans = false;
		while ((i * i) <= n) {
			if ((n - (i * i)) == 0 || play(n - (i * i), !alice, dp)) {
				ans = alice;
				break;
			}
			++i;
		}

		dp.put(n, ans);

		return ans;
	}

	public static void main(String[] args) {

		System.out.println(new Problem1510().winnerSquareGame(7));
	}

}
