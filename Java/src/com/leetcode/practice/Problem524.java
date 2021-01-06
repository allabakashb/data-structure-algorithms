package com.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem524 {

	/*
	 * class Tuple implements Comparable<Tuple>{
	 * 
	 * String wd; int count = 0;
	 * 
	 * Tuple(String wd) {
	 * 
	 * this.wd = wd; }
	 * 
	 * @Override public int compareTo(Tuple tp) {
	 * 
	 * return this.wd.compareTo(tp.wd); } }
	 * 
	 * public String findLongestWord(String strRef, List<String> dictionary) {
	 * 
	 * String longestWord = "";
	 * 
	 * Map<Character, List<Tuple>> map = new HashMap<>();
	 * 
	 * for (String wd : dictionary) {
	 * 
	 * List<Tuple> tuples = map.get(wd.charAt(0));
	 * 
	 * if (tuples == null) {
	 * 
	 * tuples = new LinkedList<>(); map.put(wd.charAt(0), tuples); }
	 * 
	 * tuples.add(new Tuple(wd)); }
	 * 
	 * for (int i = 0; i < strRef.length(); i++) {
	 * 
	 * List<Tuple> tuples = map.get(strRef.charAt(i));
	 * 
	 * if (tuples != null) {
	 * 
	 * map.put(strRef.charAt(i), new LinkedList<>()); for (int j = 0; j <
	 * tuples.size(); j++) {
	 * 
	 * Tuple tp = tuples.get(j); ++tp.count;
	 * 
	 * if (tp.count == tp.wd.length()) {
	 * 
	 * if (longestWord.length() <= tp.count) {
	 * 
	 * longestWord = tp.wd; } } else {
	 * 
	 * char tpCh = tp.wd.charAt(tp.count); List<Tuple> newTuples = map.get(tpCh);
	 * 
	 * if (newTuples == null) {
	 * 
	 * newTuples = new LinkedList<>(); map.put(tpCh, newTuples); }
	 * 
	 * newTuples.add(tp); } } } }
	 * 
	 * return longestWord; }
	 */
    
	public String findLongestWord(String strRef, List<String> dictionary) {

		String longestWord = "";

		Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < strRef.length(); i++) {
            
            List<Integer> list = map.get(strRef.charAt(i));
            
            if (list == null) {
                
                list = new ArrayList<>();
                map.put(strRef.charAt(i), list);
            }
            
            list.add(i);
        }
        
        
        for (String word: dictionary) {
            
            if (word.length() < longestWord.length()) {
                
                continue;
            }
            
            
            
            int index = -1, i = 0;
            boolean isValid = longestWord.length() > 0;
            for (i = 0; i < word.length(); i++) {
                
                List<Integer> list = map.get(word.charAt(i));
                    
                if (isValid && i < longestWord.length() && 
                       longestWord.charAt(i) > word.charAt(i)) {

                    isValid = false;
                }

                if (list == null || (isValid && i < longestWord.length() && 
                       longestWord.charAt(i) < word.charAt(i))) {

                    break;
                } else {

                  int index1 = search(list, index);

                  if (index1 <= index) break;

                  index = index1;
                }
            }
            
            if (i == word.length() && i >= longestWord.length()) {
                
                longestWord = word;
            }
        }

		return longestWord;
	}
    
    private int search(List<Integer> list, int prev) {
        
        if (list.size() == 1) {
            
            return list.get(0) != prev ? list.get(0) : -1;
        }
        
        int start = 0, end = list.size();
        while (start < end) {
            
            int mid = (start + end) / 2;
            
            int num = list.get(mid);
            if (num == prev) {
                
                return mid+1 < list.size() ? list.get(mid+1) : -1;
            } else if (num < prev) {
                
                start = mid + 1;
                
                if (start < list.size() && list.get(start) > prev) {
                	
                	return list.get(mid);
                }

            } else {
                
                end = mid - 1;
                
                if (end >= 0 && list.get(end) <= prev) {
                	
                	return list.get(mid);
                }
            }
        }
        
        return list.get(0);
    }
    
    public static void main(String[] args) {
		
    	String ref = "abpcplea";
    	String[] dict = {"ale","apple","monkey","plea"};
        			
    	Problem524 p = new Problem524();
    	System.out.println(p.findLongestWord(ref, Arrays.asList(dict)));
	}
    
    /*
     * 
     "abpcplea"
["ale","apple","monkey","plea"]
   */
}
