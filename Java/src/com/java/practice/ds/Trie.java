package com.java.practice.ds;

import java.util.ArrayList;
import java.util.List;

public class Trie {
	
	static final int ALPHABETS_SIZE = 26;

	static class TrieNode {
		
		TrieNode[] childrens = new TrieNode[ALPHABETS_SIZE];
		char ch;
		boolean endOfWord = false;
	}
	
	static TrieNode root;
	
	static void insert(String str) {
		
		TrieNode ref = root;
		
		for (int i = 0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
			int index = ch - 'a';
			
			if (ref.childrens[index] == null) {
				
				ref.childrens[index] =  new TrieNode();
				ref.childrens[index].ch = ch;
			}
			
			ref = ref.childrens[index];
		}
		
		ref.endOfWord = true;
	}
	
	static List<String> search(String query, int size) {
		
		List<String> results = new ArrayList<>();
		
		int queryLen = query.length();
		
		TrieNode ref = root;
		for (int i = 0; i < queryLen; i++) {
			
		}
		
		return results;
	}
	
	public static void main(String[] args) {
		

	}

}
