package com.hackerrank.practice;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class GeometricTriplets {

	// Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	
    	
    	long count = 0; int len = arr.size();
    	Map<Long, Integer> right = new HashMap<>(), left = new HashMap<>();

    	for (int i = 0; i < len; i++) {
    		
    		long ele = arr.get(i);
    		int numb = right.get(ele) != null ? right.get(ele) : 0;
    		
    		right.put(ele, numb + 1);
    		
    	}
    	
    	for (int i = 0; i < len; i++) {
    		
//    		long a0 = arr.get(i);
//    		for (int j = i + 1; j < len; j++) {
//    			
//    			long a1 = arr.get(j);
//    			long next = a0 * r;
//    			if (a1 != next) {
//    				
//    				if (a1 > next) {
//    					
//    					break;
//    				}
//    				continue;
//    			}
//    			
//    			next = a0 * r * r;
//    			for (int k = j + 1; k < len; k++) {
//    				
//    				long a2 = arr.get(k);
//    				
//    				if (a2 == next) {
//    					
//    					count++;
//    				} else if (a2 > next) {
//    					
//    					break;
//    				}
//    			}
//    		}
    		
    		long a0 = arr.get(i);
    		
    		right.put(a0, (right.get(a0) - 1));
    		if(a0%r==0)
    		{
    			
    			int leftC = left.get(a0/r) != null ? left.get(a0/r) : 0;
    			int rightC = right.get(a0*r) != null ? right.get(a0*r) : 0;
    			count+= leftC * rightC;
    		}
    		left.put(a0, (left.get(a0) != null ? left.get(a0) + 1 : 1));
    		
    	}
    	
    	return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(String.valueOf(ans));

        bufferedReader.close();
    }
}
