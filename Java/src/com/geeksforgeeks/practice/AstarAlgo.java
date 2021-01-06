package com.geeksforgeeks.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class AstarAlgo {

	private static final int[][] NEIGHBORS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
	//, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}
	};

	class Node implements Comparable<Node> {
		public Node(int i, int j, char p) {

			this.i = i;
			this.j = j;
			this.p = p;
		}

		int i;
		int j;
		int g = Integer.MAX_VALUE;
		int f = Integer.MAX_VALUE;
		char p;

		@Override
		public int compareTo(Node o) {

			return this.f - o.f;
		}
	}

	public static void main(String[] args) {

		int m = 3, n = 8, k = 1;
		AstarAlgo algo = new AstarAlgo();
		Node[][] input = algo.customInput(m, n); //algo.generate(m, n);

		input[0][0].p = 'o';
		input[m - 1][n - 1].p = 'o';
		input[0][0].g = 0;
		input[0][0].f = 0;
		
		print(input, m, n);
		
		int minSteps = algo.minStepsPath(input, m, n, k);

		System.out.println("steps => " + minSteps);
		print(input, m, n);
	}

	private Node[][] customInput(int m, int n) {

		Node[][] nodes = generate(10, 10);
		
		return nodes;
	}

	private static void print(Node[][] input, int m, int n) {

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				System.out.print(input[i][j].p + " ");
			}
			System.out.println("");
		}
	}

	private Node[][] generate(int m, int n) {

		Node[][] nodes = new Node[m][n];

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				char c = Math.ceil(Math.random() * 10) >= 8 ? 'x' : 'o';
				nodes[i][j] = new Node(i, j, c);
			}
		}
		return nodes;
	}

	private int minStepsPath(Node[][] input, int m, int n, int k) {

		PriorityQueue<Node> openQueue = new PriorityQueue<>();
		Set<Node> closedSet = new HashSet<>();
		openQueue.add(input[0][0]);
		closedSet.add(input[0][0]);

		Map<Node, Node> cameFrom = new HashMap<>();

		int obs = 0;
		while (!openQueue.isEmpty()) {

			Node cur = openQueue.peek(); // with lowest f score

			int i = cur.i;
			int j = cur.j;

			if (i == m - 1 && j == n - 1) {

				return reconstructPath(cameFrom, cur, input);
			}

			openQueue.poll();
			closedSet.add(cur);

			for (int[] neighbor : NEIGHBORS) {

				int n1 = neighbor[0] + i, n2 = neighbor[1] + j;

				if (n1 < 0 || n2 >= n || n2 < 0 || n1 >= m || closedSet.contains(input[n1][n2]))
					continue;

				Node nbor = input[n1][n2];

				if (nbor.p == 'x')
					++obs;

				if (obs > k) {

					--obs;
					continue;
				}

				int tempGscore = cur.g + 1;

				if (tempGscore < nbor.g) {

					cameFrom.put(nbor, cur);
					nbor.g = tempGscore;
					nbor.f = tempGscore + heuristic(n1, n2, m - 1, n - 1);

					if (!openQueue.contains(input[n1][n2])) {

						openQueue.add(input[n1][n2]);
					}
				}
			}
		}

		return -1;
	}

	private int reconstructPath(Map<Node, Node> cameFrom, Node current, Node[][] input) {

		int steps = 0;
		int i = current.i;
		int j = current.j;

		input[i][j].p = 'p';

		while (cameFrom.containsKey(current)) {

			current = cameFrom.get(current);

			i = current.i;
			j = current.j;

			input[i][j].p = 'p';
			++steps;
		}

		return steps;
	}

	private int heuristic(int i, int j, int t1, int t2) {

		return Math.max(abs(i - t1), abs(j - t2));
	}

	private int abs(int a) {

		return Math.abs(a);
	}
}
