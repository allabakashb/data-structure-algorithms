package com.leetcode.practice;

public class Sudoku {

	final static char EMPTY = '.';
	final static int LEN = 9;

	public boolean valid(char[][] board) {

		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {

				if (board[i][j] == '.')
					continue;

				int subIndex = j / 3;
				subIndex += i < 3 ? 0 : (i < 6 ? 3 : 6);

				for (int k = 0; k < LEN; k++) {
					
					if (board[i][k] == board[i][j] || board[j][k] == board[i][j] || board[subIndex][k] == board[i][j]) {

						return false;
					}
				}
			}
		}

		return true;
	}

	private boolean solve(char[][] ch) {

		for (int i = 0; i < LEN; i++) {

			for (int j = 0; j < LEN; j++) {

				if (ch[i][j] == EMPTY) {

					for (int k = 0; k < LEN; k++) {

						ch[i][j] = Character.forDigit(k + 1, 10);
						
						if (valid(ch)) {

							if (solve(ch)) {

								return true;
							} else {

								ch[i][j] = EMPTY;
							}
						} else {
							
							ch[i][j] = EMPTY;
						}
					}
					
					return false;
				}
				
			}
		}

		return true;

	}
	
	public static void main(String[] args) {

		char[][] ch = /*
						 * { { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6', '.', '.', '1', '9',
						 * '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8',
						 * '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3',
						 * '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6',
						 * '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.',
						 * '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
						 */
			{{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
		new Sudoku().solve(ch);

		for (int i = 0; i < LEN; i++) {

			for (int j = 0; j < LEN; j++) {

				System.out.print(ch[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
