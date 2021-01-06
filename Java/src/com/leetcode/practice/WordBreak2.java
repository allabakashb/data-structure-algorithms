package com.leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WordBreak2 {

class Trie {
        
        Trie[] childs;
        int endIndex;
        
        Trie() {
            
            this.childs = new Trie[26];
            this.endIndex = -1;
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> result = new ArrayList<>();
        
        Trie[] trie = new Trie[26];
        
        for (int i = 0; i < wordDict.size(); i++) {
            
            buildTrie(trie, wordDict.get(i), 0, i);
        }
        
        traverse(s, trie, 0, new LinkedList<>(), wordDict, result);
        
        return result;
    }
    
    private void traverse(String s, Trie[] trie, int index, LinkedList<Integer> indices, 
                          List<String> wordDict, List<String> result) {
        
        if (index >= s.length()) {
            
            StringBuilder sb = new StringBuilder();
            for (Integer in: indices) {
                
                sb.append(wordDict.get(in)).append(" ");
            }
            
            result.add(sb.substring(0, sb.length()-1));
            return;
        }
        
        
        Trie[] nodes = trie;
        for (int i = index; i < s.length(); i++) {
            
            Trie node = getNode(nodes, s.charAt(i));
            
            if (node == null) return;
            
            nodes = node.childs;
            if (node.endIndex > -1) {
                
                indices.add(node.endIndex);
                traverse(s, trie, i + 1, indices, wordDict, result);
                indices.removeLast();
            }
        }
    }
    
    private Trie getNode(Trie[] trie, char ch) {
        
        return trie[charIndex(ch)];
    }
    
    private void buildTrie(Trie[] trie, String str, int index, int end) {
                
        int chIndex = charIndex(str.charAt(index));
        
        if (trie[chIndex] == null) {
            
            trie[chIndex] = new Trie();
        }
        
        if (index == str.length()-1) {
            
            trie[chIndex].endIndex = end;
        } else {
            
            buildTrie(trie[chIndex].childs, str, index + 1, end);
        }
    }
    
    private int charIndex(char ch) {
        
        return ch - 'a';
    }
    
	public static void main(String[] args) {
		
		WordBreak2 wd = new WordBreak2();

		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		
		String[] str = { "a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa" };
		List<String> wordDict = new ArrayList<String>();
		for (String w: str) {
			wordDict.add(w);
		}
		
		System.out.println(wd.wordBreak(s, wordDict));
	}

}
