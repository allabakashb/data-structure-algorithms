package com.hackerearth.practice;

import java.io.BufferedReader;
import java.util.Scanner;

public class MattyAssignment {

    public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        while (t-- > 0) {
            
        	StringBuilder sb = new StringBuilder();
            long n1 = s.nextLong();
            long n2 = s.nextLong();
            
            int i = 0;            
            while (n2 != 0) {
                
               if (n2 % 2 != 0) {
                   
            	   sb.insert(0, "(" + n1 + "<<" + i + ")" + (sb.length() > 0 ? " + " : ""));
               }
               
               n2 /= 2;
               i++;
            }
            
            System.out.println(sb);
        }
    }
}
