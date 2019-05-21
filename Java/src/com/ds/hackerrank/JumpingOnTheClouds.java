package com.ds.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JumpingOnTheClouds {
	
    static int jumpingOnClouds(int[] c) {
    
    	int count = 0, jumps = 0;
    	
    	while (jumps < (c.length - 1)) {
    		
    		if ( (jumps + 2) < c.length && 
    				c[jumps + 2] != 1) {
    			jumps += 2;
    		} else {
    			++jumps;
    		}
    		
    		count++;
    	}
    	
    	return count;
    }


    public static void main(String[] args) throws Exception {

    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
        int n = Integer.parseInt(br.readLine());

        int[] ar = new int[n];

        String[] arItems = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = jumpingOnClouds(ar);

       System.out.println(result);

    }
    
}
