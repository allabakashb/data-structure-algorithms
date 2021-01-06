package com.hackerearth.oct.circuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while (t > 0) {
			
			String[] line = br.readLine().split(" ");
			
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			int n = Integer.parseInt(line[2]);
			
			int x = a ^ b;
			int e = xnor(a, b);
			
			int rim = (n % 3) - 1;
			
			if (rim == 0) {
				
				x = a;
				e = a;
			} else if (rim == 1) {
				
				x = b;
				e = b;
			}
			
			System.out.println(Math.max(x, e));
			t--;
		}
	}
	
	static int togglebit(int n) 
    { 
        if (n == 0) 
            return 1; 

        int i = n; 
  
        n |= n >> 1; 
  
        n |= n >> 2; 
        n |= n >> 4; 
        n |= n >> 8; 
        n |= n >> 16; 
  
        return i ^ n; 
    } 
  
    static int xnor(int num1, int num2) 
    { 
        if (num1 < num2) 
        { 
            int temp = num1; 
            num1 = num2; 
            num2 = temp; 
        } 
      
        num1 = togglebit(num1); 
      
        return num1 ^ num2; 
    } 
}
