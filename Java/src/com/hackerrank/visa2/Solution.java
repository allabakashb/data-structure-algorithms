package com.hackerrank.visa2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'minNum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER threshold
     *  2. INTEGER_ARRAY happy
     */

    public static int minNum(int threshold, List<Integer> happy) {
    	
    	int mid = happy.size() / 2;
    	int len = happy.size();
    	
    	int minProbs = 0; boolean found = false;
    	for (int i = 0; i < mid; i++) {
    		
    		int num1 = happy.get(i);
    		int num2 = happy.get(len - i - 1);
    		
    		if ((num2 - num1) <= threshold && i != 0) {
    			
    			minProbs = len - i;
    			found = true;
    			break;
    		}
    	}
    	
    	if (found) {
    		
    		return (minProbs / 2) + 1;
    	} else {
    		
    		return len;
    	}

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int threshold = Integer.parseInt(bufferedReader.readLine().trim());

        int happyCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> happy = IntStream.range(0, happyCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minNum(threshold, happy);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    
    }
}

