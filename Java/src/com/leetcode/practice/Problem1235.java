package com.leetcode.practice;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1235 {

	class Job {
        int startTime;
        int endTime;
        int profit;
        int maxProfit;
        
        Job(int startTime,int endTime, int profit) {
            
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
            this.maxProfit = profit;
        }
    }
    
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        Job[] jobs = new Job[startTime.length];
        
        for (int i  = 0; i < startTime.length; i++) {
            
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        
        Arrays.sort(jobs, new Comparator<Job>(){
            
            @Override
			public int compare(Job o1, Job o2) {
				
				return o1.endTime <= o2.endTime ? -1 : 1;
			}
        });
        
        
        int maxProfit = 0;
        for (int j = 1; j < jobs.length; j++) {
            
            jobs[j].maxProfit = Math.max(jobs[j].profit, jobs[j-1].maxProfit);
            
            int i = j-1;
            while (i >= 0) {
                
                if (!overlap(jobs[i], jobs[j])) {
                    
                    jobs[j].maxProfit = Math.max(jobs[j].maxProfit, 
                                              jobs[i].maxProfit+ jobs[j].profit);
                    
                    maxProfit = Math.max(maxProfit, jobs[j].maxProfit);
                    
                    break;
                }
                
                maxProfit = Math.max(maxProfit, jobs[j].maxProfit);
                --i;
            }
        }
        
        return maxProfit;
    }
    
    private boolean overlap(Job job1, Job job2) {
        
        return job1.endTime > job2.startTime;
    }
    
    public static void main(String[] args) {
		
    	int[] startTime = {1,2,3,4,5,6,7,8,9,10};
    	int[] endTime = {2,3,4,5,6,7,8,9,10,11};
    	int[] profit = {10,20,30,40,50,60,70,80,90,100};
    	
    	System.out.println(new Problem1235().jobScheduling(startTime, endTime, profit));
	}
}
