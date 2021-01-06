package com.google.kickstart2019;

import java.util.Arrays;
import java.util.Scanner;

class Training2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int testCases = sc.nextInt();
		
		int j = 0;
		while (j++ < testCases) {
			
			int N = sc.nextInt();
			int P = sc.nextInt();
			
			int[] array = new int[N];
			for (int i = 0; i < N; i++) {
				
				array[i] = sc.nextInt();
			}
			
			System.out.println("Case #"+j+": "+ getMinimumCoachingHours(array, P));
		}
		
		sc.close();
	}

	private static int getMinimumCoachingHours(int[] array, int P) {
		
		Arrays.sort(array); //1 3 9 100
		int minHours = Integer.MAX_VALUE;
		
		for (int i = array.length-1; i - P + 1 >= 0; i--) {
			
			int hours = 0;
			for (int j = i-1; j > i - P; j--) {
				
				hours += Math.abs(array[i]-array[j]);
			}
			
			if (hours < minHours) {
				
				minHours = hours;
			}
		}
		return minHours;
	}
}
