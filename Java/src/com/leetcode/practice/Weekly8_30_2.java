package com.leetcode.practice;

public class Weekly8_30_2 {

	public int getMaxLen(int[] nums) {

		int max = 0, start = 0, pos = 0;

		Boolean prod = true;
		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 0) {
				prod = null;
			} else if (nums[i] < 0) {
				prod = !prod;
			}

			if (prod == null) {

				prod = true;
				start = i + 1;
			} else if (prod) {

				max = Math.max(max, i - start + 1);
			}

			if (nums[i] > 0)
				++pos;
		}

		prod = true;
		start = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {

			if (nums[i] == 0) {
				prod = null;
			} else if (nums[i] < 0) {
				prod = !prod;
			}

			if (prod == null) {

				prod = true;
				start = i - 1;
			} else if (prod) {

				max = Math.max(max, start - i + 1);
			}

			if (nums[i] > 0)
				++pos;
		}

		return max == 0 && pos >= 1 ? 1 : max;
	}
	
	public static void main(String[] args) {
		
		Weekly8_30_2 w = new Weekly8_30_2();
		System.out.println(w.getMaxLen(new int[] {70,-18,75,-72,-69,-84,64,-65,0,-82,62,54,-63,-85,53,-60,-59,29,32,59,-54,-29,-45,0,-10,22,42,-37,-16,0,-7,-76,-34,37,-10,2,-59,-24,85,45,-81,56,86 }));
	}
}
