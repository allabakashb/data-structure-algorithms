package com.leetcode.practice;

import java.util.Scanner;

public class Problem5 {

	public static void main(String[] args) {
		
		Problem5 p5 = new Problem5();
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
			
			System.out.println(p5.longestPalindrome(sc.next()));
		}
	}
	
	private String s;
    private int[] p;
    private char[] t;
    
    public String longestPalindrome(String s) {
       
        this.s = s;
        preProcess();
        
        p = new int[t.length];
        int right =0, center = 0;
        
        for (int i = 1; i < t.length - 1; i++) {
            
            int mirror = 2 * center - i;
            if (right > i) {
                
                p[i] = Math.min(right-i, p[mirror]);
            }
            
            while(t[i+(1 + p[i])] == t[i-(1+p[i])]) {
                p[i]++;
            }
            
            if (i + p[i] > right) {
                
                right = i+ p[i];
                center = i;
            }
        }
        
        int length = 0;
        center = 0;
        for (int i = 1; i < p.length-1; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }
    
    private void preProcess() {
        
        int len = s.length();
        t = new char[2 * len + 3];
        t[0] = '$';
        
        for (int i = 0; i < len; i++) {
            
            t[2 * i + 1] = '#';
            t[2 * i + 2] = s.charAt(i);
        }
        
        t[t.length-2] = '#';
        t[t.length-1] = '@';
    }
}
