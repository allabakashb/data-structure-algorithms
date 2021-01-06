package com.leetcode.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1293 {

	public int shortestPath(int[][] grid, int k) {

		int m = grid.length;

		if (m == 0)
			return -1;

		int n = grid[0].length;

		boolean[][] visited = new boolean[m][n];

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[1] - o2[1];
			}
		});
				
		queue.add(new int[] { m-1, n-1, 0 });

		int path = 0;
		while (!queue.isEmpty()) {

			int size = queue.size();

			while (size-- > 0) {

				int[] cord = queue.poll();

				int r = cord[0];
				int c = cord[1];
				int obst = cord[2];
				
				if (r == 0 && c == 0) return obst <= k ? path : -1;

				obst += grid[r][c];
				
				if (obst > k || visited[r][c]) continue;
				
				if (r + 1 < m && !visited[r+1][c]) {

					queue.add(new int[] { r + 1, c, obst });
				}

				if (r - 1 >= 0 && !visited[r-1][c]) {

					queue.add(new int[] { r - 1, c, obst });
				}

				if (c + 1 < n && !visited[r][c+1]) {

					queue.add(new int[] { r, c + 1, obst });
				}

				if (c - 1 >= 0 && !visited[r][c-1]) {

					queue.add(new int[] { r, c - 1, obst });
				}
				
				visited[r][c] = true;
			}
		}

		return -1;
	}

	public static void main(String[] args) throws InterruptedException {

		int[][] input = { { 0, 1, 0, 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0, 0, 1, 0 } };
	    
		System.out.println(new Problem1293().shortestPath(input, 1));
	}
}
