package com.java.practice.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AmazonIn1 {


	private static List<Integer> getQueries(int q, int n) {
		
		List<Integer> queries = new ArrayList<Integer>();
		
		for (int i = 0; i < q; i++) {
			
			int num = getRandomNumber(n, 0);
			while (queries.contains(num)) {
				
				num = getRandomNumber(n, 0);;
			}
			
			//System.out.print(num + " ");
			queries.add(num);
		}
		
		//System.out.println("..query ends..");
		
		return queries;
	}
	
	private static int getRandomNumber(int range) {
		
		return getRandomNumber(range, 1);
	}
	
	private static int getRandomNumber(int range, int startIndex) {
		
		return (int)((Math.random() * range) + startIndex);
	}
	
	public static int[] getTestData(int n) {
		
		int[] data = new int[n];
		
		for (int i = 0; i < n; i++) {
			
			data[i] = getRandomNumber(15);
			
			//System.out.print(data[i] + " ");
		}
		
		//System.out.println("..Input ends..");
		return data;
	}
	
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n = sc.nextInt();
		int q = sc.nextInt();
		sc.close();
		
		for (int i = 0; i < t; i++) {
			
			int[] testData = getTestData(n);
			List<Integer> queries = getQueries(q, n);
			int[] dup = Arrays.copyOf(testData, n);

//			Stopwatch st = new Stopwatch();
//			st.start();
//			solveByBruteForce(testData, queries);
//			st.stop();
//			System.out.println((st.elapsedMillis()) + " msecs");
//			st.reset();
//			st.start();
//			solveByOptimumSolution(dup, queries);
//			st.stop();
//			System.out.println((st.elapsedMillis()) + " msecs");
			
			boolean mm = true;
			for (int j = 0; j < dup.length; j++) {
				
				if (dup[j] != testData[j]) {
					
					mm = false;
					break;
				}
			}
			
			if (mm) {
				
				System.out.println("matched");
			} else {
				
				System.out.println("not matched");
			}
		}
	}

	private static void solveByBruteForce(int[] testData, List<Integer> queries) {
		
		queries.forEach((query) -> {
			
			for (int i = query + 1; i < testData.length; i++) {
				
				if (testData[i] < testData[query]) {
					
					testData[i] = 0;
				}
			}
		});
		
		/*
		 * IntStream.of(testData).forEach(ele -> System.out.print(ele + " "));
		 * System.out.println("");
		 */
	}

	private static void solveByOptimumSolution(int[] testData, List<Integer> queries) {
		
		Set<Integer> set = new TreeSet<Integer>(queries);
		
		int startIndex = set.stream().findFirst().get();
		int max = testData[startIndex];
		for (int i = startIndex + 1; i < testData.length; i++) {
			
			if (testData[i] == 0) {
				
				continue;
			}
			
			if (set.contains(i)) {
				
				max = max < testData[i] ? testData[i] : max;
			}
			
			if (testData[i] < max) {
				
				testData[i] = 0;
			}
		}
	}

}
