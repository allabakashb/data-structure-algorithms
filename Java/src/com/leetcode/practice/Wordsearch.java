package com.leetcode.practice;

public class Wordsearch {

	 public boolean exist(char[][] board, String word) {
	        
	        for (int i = 0; i < board.length; i++) {
	            
	            for (int j = 0; j < board[i].length; j++) {
	                
	                if (exist(board, word, i, j, 0, 0) || exist(board, word, i, j, 2, 0)) {
	                    
	                    return true;
	                }
	            }
	        }
	        
	        return false;
	    }
	    
	    private boolean exist(char[][] board, String word, int i, int j,
	                          int from, int index) {
	        
	        boolean exists = false;
	        if (board[i][j] == word.charAt(index++)) {
	            
	            if (index == word.length()) return true;
	            
	            if (from != 0 && j > 0) {
	                
	                exists = exist(board, word, i, j-1, 2, index);
	            } 
	            
	            if (!exists && from != 1 && i > 0) {
	                
	                exists = exist(board, word, i-1, j, 3, index);
	            } 
	            
	            if (!exists && from != 2 && j < board[i].length - 1) {
	                
	                exists = exist(board, word, i, j+1, 0, index);
	            } 
	            
	            if (!exists && from != 3 && i < board.length - 1) {
	                
	                exists = exist(board, word, i+1, j, 1, index);
	            }        
	        }
	        
	        return exists;
	    }
	    
	public static void main(String[] args) {
		
		Wordsearch ws = new Wordsearch();
		char[][] board = {{'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'} };
		System.out.println(ws.exist(board, "aaaaaaaaaaaaa"));
	}

}
