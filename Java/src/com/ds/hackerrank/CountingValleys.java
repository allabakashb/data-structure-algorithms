package com.ds.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CountingValleys {

	
	// Complete the sockMerchant function below.
    static int countingValleys(int n, String s) {
    	int count = 0;
    	int valleys = 0;
    	for (int i = 0; i < s.length(); i++) {
    		
     		if (s.charAt(i) == 'U') {
    			++count;
    		} else {
    			--count;
    		}
    		
    		if (count == 0 && s.charAt(i) == 'U') {
    			++valleys;
    		}
    	}
    	
    	return valleys;
    }


    public static void main(String[] args) throws Exception {

    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
        int n = Integer.parseInt(br.readLine());

        int result = countingValleys(n, br.readLine());

       System.out.println(result);

    }
    
}
