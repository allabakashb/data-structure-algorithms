package com.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1345 {

	public int minJumps(int[] arr) {

		Map<Integer, List<Integer>> pMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (pMap.containsKey(arr[i])) {
				pMap.get(arr[i]).add(i);
			} else {
				List<Integer> list = new ArrayList<>();
				pMap.put(arr[i], list);
				list.add(i);
			}
		}

		int jumps = minJumps(0, arr, pMap, new int[arr.length]);

		return jumps + 1;
	}

	private int minJumps(int index, int[] arr, Map<Integer, List<Integer>> pMap, int[] dp) {

		if (index >= arr.length || index < 0 || dp[index] < 0)
			return arr.length + 1;

		if (index == arr.length - 1)
			return 0;

		if (dp[index] != 0)
			return dp[index];

		dp[index] = -1;
		int min = Integer.MAX_VALUE;

		for (Integer pIndex : pMap.get(arr[index])) {
			if (index != pIndex)
				min = minJumps(pIndex, arr, pMap, dp);
		}

		dp[index] = Math.min(min, Math.min(minJumps(index + 1, arr, pMap, dp), minJumps(index - 1, arr, pMap, dp)));

		dp[index] = Math.min(dp[index], arr.length - index);

		return dp[index] + 1;
	}

	public static void main(String[] args) {

		int[] arr = { 80,-86,40,12,40,-98,12,-86,-79,-4,-79,71,44,-43,-9,-88,88,-43,31,4,71,-86,55,-9,-65 };
		System.out.println(new Problem1345().minJumps(arr ));
	}
}
