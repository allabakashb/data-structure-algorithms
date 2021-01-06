package com.hackerearth.practice;

import java.util.Scanner;

public class ValentineShopping {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        while (t-- > 0) {
            
            int n = s.nextInt();
            int m = s.nextInt();
            
            for (int i = 0; i < n; i++) {
                
                float max = Integer.MAX_VALUE; int index = 1;
                for (int j = 0; j < m; j++) {
                    
                    float base = 10;
                    for (int k = 0; k < 3; k++) {
                        
                        base -= (base * s.nextInt()/100);
                    }
                    
                    if (max > base) {
                        
                        max = base;
                        index = j + 1;
                    }
                }
                System.out.print(index + " ");
            }
            
            System.out.println("");
        }

	}

}
