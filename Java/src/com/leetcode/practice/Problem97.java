package com.leetcode.practice;

public class Problem97 {

	public boolean isInterleave(String s1, String s2, String s3) {

		if (s3.length() != (s1.length() + s2.length()))
			return false;

		boolean[] status = new boolean[s3.length()];

		return isSubSequence(s3, s1, status) && isSubSequence(s3, s2, status);
	}

	private boolean isSubSequence(String s1, String s2, boolean[] status) {
		int i = 0, j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (!status[i] && s1.charAt(i) == s2.charAt(j)) {
				status[i] = true;
				++j;
			}
			++i;
		}

		return j == s2.length();
	}

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(new Problem97().isInterleave(s1, s2, s3));
	}
	
	/*
	ttdtbtbtac
	aabcc	
	 */

}
