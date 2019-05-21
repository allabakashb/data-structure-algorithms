package com.ds.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RepeatedString {

	
    static long repeatedString(String s, long n) {
    	
    	long aCount = 0, remainingACount = 0;
    	int length = s.length();
    	
    	long actualLength = n / length;
    	long remainingLength = n % length;    	
    	int aIndex = s.indexOf('a');
    	
    	while (aIndex > -1) {
    		aCount++;
    		if (aIndex < remainingLength) {
    			remainingACount++;
    		}
    		aIndex = s.indexOf('a', aIndex + 1);
    	}
    	
    	return (aCount * actualLength) + remainingACount;
    }


    public static void main(String[] args) throws Exception {

    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
        long result = repeatedString(br.readLine(), Long.parseLong(br.readLine()));

       System.out.println(result);

    }
    
}
