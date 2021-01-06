package com.hackerearth.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChandanTimer {

public static void main(String args[] ) throws Exception {
        
        int[] array = new int[60];
        
        for (int i = 2; i < 60; i++) {
            
            array[i] += array[i-1];
            if (isPrime(i)) {
                
                array[i]++;
            }
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            
            String[] time = br.readLine().split(" ");
        
            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            int s = Integer.parseInt(time[2]);
            
            int hP = array[23];
            
            if (h > 1) {
                
                hP = array[23] - array[h-1];
            }
            
            int mP = array[59];
            
            if (m > 1) {
                
                mP = array[59] - array[m-1];
            }
            
            int sP = array[59];
            
            if (s > 1) {
                
                sP = array[59] - array[s-1];
            }
            
            int good = hP + mP + sP;
            
            int ans1 = good - 2;
            int ans2 = good - 3;
            int gd1 = good;
            while (ans1 > 1 || ans2 > 1) {
            	
            	if (ans1 > 1) {
            		
            		gd1 *= 
            		ans1--;
            	}
            }
            	
            	
            int bad = ((23 - h) * 60 * 60) + ((59 - m) * 60) + 59 - s - good;
            
            System.out.println(bad+":"+good);
        }

    }
    
    static boolean isPrime(int n) {
        
        if (n <= 1) return false;
        if (n <= 3) return true;
        
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        for (int i =5; i * i <= n; i= i + 6) {
            
            if (n % i  ==0 || n % (i + 2) == 0) 
            return false;
        }
        
        return true;
    }
}
