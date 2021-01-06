package com.hackerearth.practice;

import java.util.Scanner;

public class SweetDogs {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
        	
        	int p = sc.nextInt();
        	int q = sc.nextInt();
        	int s = sc.nextInt();
        	
        	int counter = 0, len = q;
        	while (true) {
        		
        		int div = len / s;
        		
    			
    			if (div > 1) {
    				
    				counter++;
    				len -= p == 1 ? (s * div) : 0;
    				p--;
    				
    			} else if (p > 0 && len != q) {
    				
    				p--;
    			} else {
    				
    				break;
    			}
    			
        	}
        	if (counter % 2 == 0) {
        		
        		System.out.println("Havanese");
        	} else {
        		
        		System.out.println("Bernard");
        	}
        }
	}
}
