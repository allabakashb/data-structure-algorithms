package com.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class Problem57 {

	public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int i = 0;
        List<int[]> result = new ArrayList<>();
        while (i < intervals.length) {
            
            if (intervals[i][1] >= newInterval[0]) {
                
                if (intervals[i][0] > newInterval[0]) {
                    
                    if (intervals[i][0] > newInterval[1]) {
                        
                        result.add(newInterval);
                        break;
                    } else if (intervals[i][1] > newInterval[1]) {
                        
                        intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
                        result.add(intervals[i++]);
                        break;
                    }
                }
                
                int k = i;
                while (i < intervals.length && intervals[i][1] < newInterval[1]) {
                    ++i;
                }
                
                if (i < intervals.length) {
                    intervals[k][1] = intervals[i][1];
                } else {
                    intervals[k][1] = newInterval[1];
                }
                
                result.add(intervals[k]);
                break;
            } else {
                
                result.add(intervals[i++]);
            }
        }
        
        if (intervals[intervals.length-1][1] < newInterval[0]) {
            
            result.add(newInterval);
        }
        
        while (i < intervals.length) {
            
            result.add(intervals[i++]);
        }
        
        int[][] mergedIntervals = new int[result.size()][2];
        i = 0;
        for (int[] inter: result) {
            
            mergedIntervals[i++] = inter;
        }
        
        return intervals;
    }
	
	public static void main(String[] args) {
		
		Problem57 p57 = new Problem57();
		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newInterval = {4, 8};
		p57.insert(intervals, newInterval);
		new ArrayList<>(10);
	}

}
