package com.hackerearth2020.april.circuit;

import java.util.Scanner;

public class CyclicShifts {

	public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);

        int t = s.nextInt();

        while (t-- > 0) {

            int num = s.nextInt();
            int m = s.nextInt();
            String dir = s.next();

            int[] bits = getBits(num);

            int res = 0, pow = 0;
            if (dir.equals("L")) {
                for (int i = m-1; i >= 0; i--) {

                    res += bits[i] * Math.pow(2, pow);
                    pow++;
                }

                for (int i = 15; i >= m; i--) {

                    res += bits[i] * Math.pow(2, pow);
                    pow++;
                }
            } else {

                for (int i = 16-m-1; i >= 0; i--) {

                    res += bits[i] * Math.pow(2, pow);
                    pow++;
                }

                for (int i = 15; i > 16-m-1; i--) {

                    res += bits[i] * Math.pow(2, pow);
                    pow++;
                }
            }

            System.out.println(res);
        }
        s.close();
    }

    private static int[] getBits(int n) 
    { 

        int[] res = new int[16];

        for (int i = 15; i >= 0; i--) { 
            int k = n >> i; 
            if ((k & 1) > 0) 
                res[15-i] = 1; 
            else
                res[15-i] = 0; 
        } 

        return res;
    } 
}
