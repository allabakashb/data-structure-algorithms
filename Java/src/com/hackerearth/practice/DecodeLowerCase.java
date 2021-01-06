package com.hackerearth.practice;

import java.util.Scanner;

public class DecodeLowerCase {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
        String input = s.next();
        
        double num = 0; int pow = 0;
        
        char[] array = input.toCharArray();
        for (int i = array.length-1; i >= 0; i--) {
            
            num = (num+((array[i] - 'a' + 1) * Math.pow(10, pow))) % 6;
            pow++;
        }
        
        System.out.println(num == 0 ? "YES" : "NO");
        	
	}

}
