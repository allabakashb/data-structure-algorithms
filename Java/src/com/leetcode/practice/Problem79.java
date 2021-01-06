package com.leetcode.practice;

public class Problem79 {

	public static void main(String[] args) {
		
		Problem79 p = new Problem79();
		
		char[][] board = {
					{'C','A','A'},
					{'A','A','A'},
					{'B','C','D'}
				};
		String word = "AAB";

		System.out.println(p.exist(board, word));
	}

	public boolean exist(char[][] board, String word) {

		int m = board.length;

		if (m == 0 || word.length() > (m * board[0].length))
			return false;

		int n = board[0].length;

		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {

				if (exist(board, word, i, j, 0, visited)) {

					return true;
				}
			}
		}

		return false;
	}

	private boolean exist(char[][] board, String word, int i, int j, int index, boolean[][] visited) {

		if (index == word.length())
			return true;

		boolean exists = false;
		if (board[i][j] == word.charAt(index)) {

			visited[i][j] = true;
			++index;
			if (j > 0 && !visited[i][j - 1]) {

				visited[i][j - 1] = true;
				exists = exist(board, word, i, j - 1, index, visited);
				visited[i][j - 1] = false;
			}

			if (!exists && i > 0 && !visited[i - 1][j]) {
				visited[i - 1][j] = true;
				exists = exist(board, word, i - 1, j, index, visited);
				visited[i - 1][j] = false;
			}

			if (!exists && j < board[i].length - 1 && !visited[i][j + 1]) {
				visited[i][j + 1] = true;
				exists = exist(board, word, i, j + 1, index, visited);
				visited[i][j + 1] = false;
			}

			if (!exists && i < board.length - 1 && !visited[i + 1][j]) {
				visited[i + 1][j] = true;
				exists = exist(board, word, i + 1, j, index, visited);
				visited[i + 1][j] = false;
			}

			visited[i][j] = false;
		}

		return exists || index == word.length();
	}

}
