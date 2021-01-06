package com.hackerrank.visa4;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    

/*
 * Complete the function below.
 */

    static String mergeStrings(String a, String b) {
    	
    	char[] array1 = a.toCharArray();
    	char[] array2 = b.toCharArray();
    	
    	int len1 = array1.length;
    	int len2 = array2.length;

    	int i = 0, j = 0;
    	
    	String result = "";
    	while (i < len1 && j < len2) {
    		
    		result += String.valueOf(array1[i]) + String.valueOf(array2[j]);
    		i++;
    		j++;
    	}
    	
    	if (i < len1) {
    		
    		result += a.substring(i, len1);
    	}
    	
    	if (j < len2) {
    		
    		result += b.substring(j, len2);
    	}
    	
    	return result;
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String res;
        String _a;
        try {
            _a = in.nextLine();
        } catch (Exception e) {
            _a = null;
        }
        
        String _b;
        try {
            _b = in.nextLine();
        } catch (Exception e) {
            _b = null;
        }
        
        res = mergeStrings(_a, _b);
        
        System.out.println(res);
    }
}
