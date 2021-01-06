package com.leetcode.practice;

public class Weekly8_30 {

	public boolean containsPattern(int[] arr, int m, int k) {
	     
        if (arr.length < (m * k)) return false;
        
        if (k == 1) return m <= arr.length;
        
        if (m == 1) {
            int i = 1;
            int n = 1;
            while (i < arr.length) {
                
                if (arr[i] == arr[i-1]) {
                    
                    ++n;
                } else {
                    
                    n = 1;
                }
                
                if (n == k) return true;
                
                ++i;
            }
            
            return false;
        }
        
        
        int n = 0, count = 1;
        for (int i = n; i < arr.length; i++) {
                        
            int j = i + m;
            
            if ((j + m) > arr.length) return false;
            
            int q = 0;
            while (q < m) {
                
                if (arr[i + q] != arr[j + q]) {
                    i = n;
                    ++n;
                    count = 1;
                    --q;
                    break;
                }
                
                ++q;
            }
            
            if (q == m) {
                
                ++count;
                i = j + m;
            }
            
            if (count == k) {
                
                return true;
            }
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		
		Weekly8_30 w = new Weekly8_30();
		System.out.println(w.containsPattern(new int[] { 1,2,1,2,1,3 }, 2, 3));
	}
}
