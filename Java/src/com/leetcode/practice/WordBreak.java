package com.leetcode.practice;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		System.out.println(wb.wordBreak(getString(), getDict()));
	}
	
	private static List<String> getDict() {
		String[] words = { "a","b","bbb","bbbb" };
		return Arrays.asList(words);
	}

	private static String getString() {
		return "bb";
	}

	class Tree {
        boolean end = false;
        Tree[] childs = new Tree[26];
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, buildTrie(wordDict));
    }
    private boolean wordBreak(String s, int start, Tree[] trie) {
        if (start >= s.length()) return true;
        Tree[] root = trie;
        while (start < s.length()) {
            int index = s.charAt(start) - 'a';
            if (root[index] == null) return false;
            if (root[index].end) {
                if (wordBreak(s, start+1, trie)) return true;
            }
            root = root[index].childs;
            ++start;
        }
        return false;
    }
    private Tree[] buildTrie(List<String> wordDict) {
        Tree[] trie = new Tree[26];
        for (String word: wordDict) {
            build(word, 0, trie);
        }
        return trie;
    }
    private void build(String word, int start, Tree[] trie) {
        if (start >= word.length()) return;
        int index = word.charAt(start) - 'a';
        if (trie[index] == null) {
            trie[index] = new Tree();
            trie[index].end = start == word.length()-1;
        }
        build(word, start+1, trie[index].childs);
    }
}
