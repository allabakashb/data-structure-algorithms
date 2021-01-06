package com.java.practice.ds;

import java.util.Scanner;
import java.util.stream.IntStream;

public class AmazonInt2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int j = 0; j < T; j++) {
			
			int N = sc.nextInt();
			
			int[] array = new int[N];
			for (int i = 0; i < N; i++) {
				
				array[i] = sc.nextInt();
			}
			
			System.out.println("");
			IntStream.of(array).forEach(System.out::print);
			getLargestArray(array, N);
			System.out.println("");
			IntStream.of(array).forEach(System.out::print);
			System.out.println("");
		}
		
		sc.close();
	}

	private static void getLargestArray(int[] array, int n) {
		
		int Gi = n-1, Si = -1, Li = Gi;
		for (int i = n-2; i >= 0; i--) {
			
			if (array[i] > array[Gi]) {
				
				if (i > Si) {
					
					Gi = i;
				} 
				
				Li = i;
			} else {
				
				Si = i;
				Gi = Li;
			}
		}
		
		if (Si != -1) {
			
			int temp = array[Gi];
			array[Gi] = array[Si];
			array[Si] = temp;
		}
	}

}
