package com.leetcode.practice;

public class Problem135 {

	public int candy(int[] ratings) {

		int len = ratings.length;
		int[] candies = new int[len];

		int sum = 0;
		for (int i = 0; i < len; i++) {

			int maxLeft = candies[i];
			int maxRight = i < len - 1 ? candies[len - i - 2] : 0;

			if (i > 0 && ratings[i] > ratings[i - 1]) {

				maxLeft = Math.max(maxLeft, candies[i - 1] + 1);
			}

			if (i < len - 1 && ratings[len - i - 2] > ratings[len - i - 1]) {

				maxRight = Math.max(maxRight, candies[len - i - 1] + 1);
			}

			if (i < len / 2) {

				sum += maxLeft + maxRight;
			} else {

				if (candies[i] < maxLeft) {

					sum -= candies[i];
					sum += maxLeft;
				}

				if (i < len - 1 && candies[len - i - 2] < maxRight) {

					sum -= candies[len - i - 2];
					sum += maxRight;
				}
			}

			candies[i] = maxLeft;

			if (i < len - 1)
				candies[len - i - 2] = maxRight;
		}

		print(candies);
		return sum + ratings.length;
	}

	private void print(int[] array) {
		for (int n: array) {
			
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public int candy1(int[] ratings) {

		int[] candies = new int[ratings.length];

		for (int i = 1; i < ratings.length; i++) {

			if (ratings[i] > ratings[i - 1]) {

				candies[i] = candies[i - 1] + 1;
			}
		}

		int sum = candies[ratings.length - 1];
		for (int i = ratings.length - 2; i >= 0; i--) {

			if (ratings[i] > ratings[i + 1]) {

				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}

			sum += candies[i];
		}

		print(candies);
		return sum + ratings.length;
	}

	public static void main(String[] args) {

		Problem135 pp = new Problem135();
		System.out.println(pp.candy(new int[] { 0, 1, 2, 3, 2, 1 }));
		System.out.println(pp.candy1(new int[] { 0, 1, 2, 3, 2, 1 }));
	}
	
	//0 1 2 3 0 0
	//0 1 2 3 1 0

}