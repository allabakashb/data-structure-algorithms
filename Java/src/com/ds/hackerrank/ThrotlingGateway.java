package com.ds.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ThrotlingGateway {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int requestTimeCount = Integer.parseInt(br.readLine().trim());

        List<String> requestTimeTemp = new ArrayList<>();

        IntStream.range(0, requestTimeCount).forEach(i -> {
            try {
                requestTimeTemp.add(br.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
		List<Integer> requestTime = requestTimeTemp.stream()
	            .map(String::trim)
	            .map(Integer::parseInt)
	            .collect(toList());
		
		System.out.println(droppedRequests(requestTime));
	}
	
	// Complete the droppedRequests function below.
    static int droppedRequests(List<Integer> requestTime) {
    	
    	int droppedRequests = 0, prev = 0, count = 0, overallCount = 0;
    	
    	for (Integer secs: requestTime) {
    		
    		if (prev == 0) {
    			prev = secs;
    		}
    		
    		overallCount++;
    		
    		if (prev == secs) {
    			count += secs;
    		} else {
    			
    			int expected = 0;
    			if (count % 3 != 0 && count > 3) {
    				
    				expected += (count % 3);
    			}
    			
    			if (overallCount % 10 == 0) {
    				
    				
    			}
    			
    		}
    		
    	};
    	
    	return droppedRequests;

    }
	
}
