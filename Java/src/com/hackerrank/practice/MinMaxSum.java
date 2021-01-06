package com.hackerrank.practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class MinMaxSum {

	// Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        long minSum = 0;
        long maxSum = 0;
        
        for (int i = 0; i < arr.length; i++) {
        	
        	for (int j = i + 1; j < arr.length; j++) {
        		
        		if (arr[j] < arr[i]) {
        			
        			int temp = arr[i];
        			arr[i] = arr[j];
        			arr[j] = temp;
        		}
        	}
        }

        for (int i = 0; i < arr.length; i++) {

            if (i < arr.length - 1) {

                minSum += arr[i];
            }

            if (i > 0) {

                maxSum += arr[i];
            }
        }

        System.out.println(minSum + " " + maxSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }

}
