package com.google.kickstart2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Training {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int testCases = sc.nextInt();
		
		int j = 0;
		while (j++ < testCases) {
			
			System.out.println("Case #"+j+": "+ getMinimumCoachingHours(sc));
		}
		
		sc.close();
	}

	private static int getMinimumCoachingHours(Scanner sc) {
		
		int N = sc.nextInt();
		int P = sc.nextInt();
		
		int[] skills = new int[N];
		for (int i = 0; i < N; i++) {
			
			skills[i] = sc.nextInt();
		}
		
		Arrays.sort(skills); 
		int minHours = Integer.MAX_VALUE;
		int sum = 0;
		
		for (int i = 0; i < P-1; i++) {
			
			sum += skills[i];
		}
		
		for (int i = P-1; i < skills.length; i++) {
			
			sum += skills[i];
			
			int hours = P * skills[i] - sum;
			
			minHours = Math.min(minHours, hours);
			
			sum -= skills[i-P+1];
		}
		
		new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		return minHours;
	}
}
