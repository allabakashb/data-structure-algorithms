package com.hackerearth.test1;

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String A = br.readLine();
            String B = br.readLine();

            int out_ = solve(A, B);
            System.out.println(out_);
         }

         wr.close();
         br.close();
    }
    static int solve(String A, String B){
        // Write your code here
    
        //case 0 , no operation
        int al = A.length();
        int bl = B.length();
        int st = 0, diff = 0, min = 0;
        while (st < al) {
            
            if (B.indexOf(A.substring(st, al)) == 0) {
                diff = al - st;
                break;
            }
            
            st++;
        }

        min = al + bl - diff;
        
        diff = al;
        st = 0;
        //case 1 or case 2, reverse A or B
        for (int i = al - 1; i > -1; i--) {
            
            if (st >= bl) {
                break;
            }
            if (A.charAt(i) != B.charAt(st)) {
                
                diff = al - i - 1;
                st = 0;
            } else {
                
                st++;
            }
            
        }
        
        int min2 = al + bl - min;
        
        min = min2 < min ? min2 : min;
        //case 3 , 1st char remove from A
        return min;
    }
}