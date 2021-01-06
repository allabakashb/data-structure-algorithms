package com.leetcode.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem3 {

	 Map<Character, Integer> map = new HashMap<>();
    public int lengthOfLongestSubstring(String s) {
        
        int maxLen = s.isEmpty() ? 0 : 1;
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            Integer index = map.get(c);
            
            if (index != null && index >= start) {
                
            	start = index + 1;
            }
            
            end++;
            map.put(c, i);
            
           maxLen = Math.max(maxLen, end - start);
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
		
    	Problem3 pr = new Problem3();
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println(pr.lengthOfLongestSubstring(sc.next()));
	}
}
