package com.leetcode.practice;

public class ValidSudoko {

	public boolean isValidSudoku(char[][] board) {
        
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] sub = new boolean[9][9];
        
        for (int i = 0; i < 9; i++) {
            
            for (int j = 0; j < 9; j++) {
                
                if (board[i][j] == '.') continue;
                
                int n = Character.getNumericValue(board[i][j]) - 1;
                
                int subIndex = j / 3;
                subIndex +=  i < 3 ? 0 : ( i < 6 ? 3 : 6);
                
                
                if (!rows[i][n] && !cols[j][n] && !sub[subIndex][n]) {
                    
                    rows[i][n] = true;
                    cols[j][n] = true;
                    sub[subIndex][n] = true;
                } else {
                    
                    return false;
                }
            }
        }
        
        return true;
    }

	public static void main(String[] args) {
		
		char[][]  ch = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(new ValidSudoko().isValidSudoku(ch));

	}

}
