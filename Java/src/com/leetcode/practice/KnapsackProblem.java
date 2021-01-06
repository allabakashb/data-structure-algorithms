package com.leetcode.practice;

public class KnapsackProblem {

	public static void main(String[] args) {

		int maxWeight = 5;
		//int[] values = random(10, maxWeight, "values");
		//int[] weights = random(10, maxWeight, "weights");
		
		int[] values = {1, 2, 4, 5, 10};
		int[] weights = {1, 3, 5, 6, 7};

		System.out.println(solve(values, weights, 15));
	}

	static int[] random(int len, int max, String label) {

		int[] result = new int[len];

		label += "[ ";
		for (int i = 0; i < len; i++) {

			result[i] = (int) (Math.random() * max + max);

			label += result[i] + (i < len - 1 ? ", " : " ");
		}

		System.out.println(label + "]");
		return result;
	}
	
	static int solve(int[] values, int[] weights, int maxWeight) {

		int[][] costs = new int[values.length + 1][maxWeight + 1];

		for (int i = 1; i <= weights.length; i++) {

			for (int j = 1; j <= maxWeight; j++) {

				if (weights[i - 1] > j) {

					costs[i][j] = costs[i - 1][j];
				} else {

					costs[i][j] = Math.max(costs[i - 1][j], 
							values[i - 1] + costs[i - 1][j - weights[i-1]]);
				}
			}
		}

		print(costs, weights, values);
		return costs[values.length][maxWeight];
	}


	private static void print(int[][] costs, int[] weights, int[] values) {

		for (int i = 0; i < costs.length; i++) {

			if (i > 0 ) {
				
				System.out.print("(" + values[i - 1] + ") " + weights[i - 1] + " ");
			} else {
				
				System.out.print("(0) 0 ");
			}
			
			for (int j = 0; j < costs[0].length; j++) {

				System.out.print(costs[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
