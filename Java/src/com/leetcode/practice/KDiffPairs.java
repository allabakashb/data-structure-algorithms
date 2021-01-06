package com.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KDiffPairs {

	public static void main(String[] args) {
		KDiffPairs kdp = new KDiffPairs();
		int[] nums= { -1, -2, -3 };
		System.out.println(kdp.findPairs(nums, 1));
	}

	public int findPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int pairs = 0;
        for (int n: nums) {
            List<Integer> pairList;
            if (map.containsKey(n)) {
                pairList = map.get(n);
                pairList.set(0, pairList.get(0)+1);
            } else {
                pairList = new ArrayList<>();
                pairList.add(1);
                pairList.add(null);
                pairList.add(null);
                map.put(n, pairList);
            }
            
            if (n == n-k || n == n+k) {
                if (pairList.get(1) == null && pairList.get(0) > 1) {
                    pairList.set(1, n);
                    ++pairs;
                }
            } else {
                pairs += getPairCount(n-k, pairList, map, 1) + getPairCount(n+k, pairList, map, 2);
            }
        }
        return pairs;
    }
    
    private int getPairCount(Integer m, List<Integer> pairList, Map<Integer, List<Integer>> map, int index) {
      if (pairList.get(0) > 0 && pairList.get(index) != m && map.containsKey(m)) {
          pairList.set(index, m);
          pairList.set(0, pairList.get(0)-1);
          return 1;
       }
       return 0;
    }
}
