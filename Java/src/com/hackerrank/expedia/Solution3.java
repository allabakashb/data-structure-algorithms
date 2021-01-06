package com.hackerrank.expedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution3 {

	public static int deleteProducts(List<Integer> ids, int m) {
	    
		Map<Integer, Integer> countMap = new HashMap<>();
		
		for (int i = 0; i < ids.size(); i++) {
			
			int id = ids.get(i);
			
			Integer counter = countMap.get(id);
			
			if (counter == null) {
				
				counter = 1;
			} else {
				
				counter++;
			}
			
			countMap.put(id, counter);
		}
		
		List<Integer> newList = new ArrayList<>(countMap.values());
		
		Collections.sort(newList);
		
		int removedIds = 0;
		for (Integer count: newList) {
						
			if (m >= count) {
				
				m -= count;		
				removedIds++;
			} else {
				
				break;
			}
		}
		
		int diff = newList.size() - removedIds;
		return diff > 0 ? diff : 0;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> ids = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			
			ids.add(sc.nextInt());
		}
		
		System.out.println(deleteProducts(ids, sc.nextInt()));
		
		sc.close();
	}
}
