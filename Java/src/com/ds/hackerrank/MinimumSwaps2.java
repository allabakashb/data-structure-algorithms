package com.ds.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumSwaps2 {

	public static void main(String[] args) throws Exception {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int n = Integer.parseInt(br.readLine());
    	
    	int[] array = new int[n];
    	//String[] ar = br.readLine().split(" ");
    	
    	List<Integer> list = new ArrayList<Integer>();

    	for (int i = 0; i < n; i++) {
    		
    		list.add(i + 1);
    	}
    	
    	Collections.shuffle(list);
    	
    	System.out.println(minimumSwaps(list.toArray()));
    	
	}
	
	 // Complete the minimumSwaps function below.// 5 4 1 3 2
    static int minimumSwaps(Object[] objects) {
    	
    	int n = objects.length, swaps = 0;
    	
    	for (int i = 0; i < n; i++) {
    		
    		if ((i + 1) != (int) objects[i]) {
    			
    			while (true) {
    				
    				int num = (int) objects[i];
    				int pair = (int) objects[num - 1];
    				
    				objects[num - 1] = objects[i];
    				objects[i] = pair;
    				
    				swaps++;
    				
    				if ((int)objects[i] == (i + 1)) {
    					break;
    				}
    			}
    		}
    		
    	}
    	
    	return swaps;

    }

}


// https://www.hackerrank.com/challenges/minimum-swaps-2