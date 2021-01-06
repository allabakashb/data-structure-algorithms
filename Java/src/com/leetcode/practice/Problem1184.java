package com.leetcode.practice;

import java.util.Deque;
import java.util.LinkedList;

public class Problem1184 {

	public int distanceBetweenBusStops(int[] distance, int start, int destination) {
	    
        if (start > destination) 
            return distanceBetweenBusStops(distance, destination, start);
        
        int cost1 = 0;
        int i = start;
        while (i != destination) {
            
            cost1 += distance[i];
            
            if (i < distance.length-1) {
                
                ++i;
            } else {
                
                i = 0;
            }
        }
                
        int cost2 = 0;
        int j = start-1;
        while (j != destination) {
               
        	cost2 += distance[j];
            if (j > 0) {
                
                --j;
            } else {
                
                j = distance.length-1;
            }
        }
        
        return Math.min(cost1, cost2);
    }
	
	public static void main(String[] args) {
		
		int[] arr = {7,10,1,12,11,14,5,0};
		

		Deque<Integer> queue = new LinkedList<>();
		
		queue.remove(1);
		System.out.println(new Problem1184().distanceBetweenBusStops(arr, 2, 7));
	}

}
