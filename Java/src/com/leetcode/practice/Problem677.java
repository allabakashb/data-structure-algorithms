package com.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class Problem677 {

	class Trie {
		Trie[] chars = null;
		int sum = 0;
	}

    Map<String, Integer> countMap = new HashMap<>();
	Trie mapSum;

	/** Initialize your data structure here. */
	public Problem677() {

		mapSum = new Trie();
	}

	public void insert(String key, int val) {

        Integer found = countMap.get(key);
        
        if (found == null) {
            
        	found = 0;
        }
        
        countMap.put(key, val);

		add(key, 0, val-found, mapSum);
	}

	private void add(String key, int charIndex, int val, Trie sum) {

		if (charIndex >= key.length())
			return;

		int index = key.charAt(charIndex) - 'a';

		if (sum.chars == null) {

			sum.chars = new Trie[26];
		}

		if (sum.chars[index] == null) {

			sum.chars[index] = new Trie();
		}

		sum.chars[index].sum += val;

		add(key, ++charIndex, val, sum.chars[index]);
	}

	public int sum(String prefix) {

		return get(prefix, 0, mapSum);
	}

	private int get(String prefix, int charIndex, Trie summer) {

		int index = prefix.charAt(charIndex) - 'a';

		if (summer == null || summer.chars == null || summer.chars[index] == null) {

			return 0;
		}

		if (charIndex == prefix.length() - 1) {

			return summer.chars[index].sum;
		}

		return get(prefix, ++charIndex, summer.chars[index]);
	}

	public static void main(String[] args) {		
		Problem677 pp = new Problem677();
		pp.insert("aa", 3);
		System.out.println(pp.sum("a"));
		pp.insert("aa", 2);
		System.out.println(pp.sum("a"));
	}

}
