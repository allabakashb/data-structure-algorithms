package com.leetcode.practice;

public class Problem43 {

	public String multiply(String num1, String num2) {

		if (num1.equals("0") || num2.equals("0"))
			return "0";

		int len1 = num1.length();
		int len2 = num2.length();

		int[] result = new int[len1 + len2];

		int k = 1;

		for (int i = len2 - 1; i >= 0; i--) {

			int index = result.length - k;
			int carry = 0, sumCarry = 0;

			int a = intVal(num2.charAt(i));

			for (int j = len1 - 1; j >= 0; j--) {

				int b = intVal(num1.charAt(j));

				int res = a * b;

				result[index] += (res % 10) + carry + sumCarry;

				carry = res / 10;

				sumCarry = result[index] / 10;
				result[index--] %= 10;
			}

			if (carry > 0) {

				result[index] += carry;
			}

			if (sumCarry > 0) {

				result[index] += sumCarry;
			}

			++k;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < result.length; i++) {

			if (i > 0 || result[i] > 0) {

				sb.append(result[i]);
			}
		}
		return sb.toString();
	}

	private int intVal(char ch) {

		return ch - '0';
	}

	public static void main(String[] args) {

		Problem43 pp = new Problem43();
		System.out.println(pp.multiply("3333", "333"));
		char ch = 190;
		System.out.println(Boolean.getBoolean("t"));
		System.out.println(Boolean.getBoolean("false"));
	}

}
