package com.leetcode.practice;

import java.util.ArrayList;

public class SortedArrayInserter {

	public static void main(String[] args) {
		
		int[] array = { 12, 10, 13, 11, 5, 15, 1, 11, 6, 17, 14, 8, 17, 6, 4, 16, 8, 10, 1, 12, 0};
		
		ArrayList<Integer> stream = new ArrayList<>();

		for (int num: array) {
						
			int start = 0, end = stream.size();
	        
	        while (start < end) {
	            
	            int mid = (start+end)/2;
	            
	            if (stream.get(mid) > num) {
	                
	                end = mid - 1;
	            } else {
	                
	                start = mid+1;
	            }
	        }
	        
	        if (stream.size() > start && stream.get(start) < num) ++start;
	        
	        stream.add(start, num);
		}

		stream.forEach(num -> System.out.print(num + " "));
	}

	//10 12 13
}

/*
 
 ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
[[],[12],[],[10],[],[13],[],[11],[],[5],[],[15],[],[1],[],[11],[],[6],[],[17],[],[14],[],[8],[],[17],[],[6],[],[4],[],[16],[],[8],[],[10],[],[2],[],[12],[],[0],[]]
 
 
 */
