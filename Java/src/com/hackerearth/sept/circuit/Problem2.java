package com.hackerearth.sept.circuit;

import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long d = sc.nextInt();
		long Oc = sc.nextInt();
		long Of = sc.nextInt();
		long Od = sc.nextInt();
		
		double Cs = sc.nextInt();
		double Cb = sc.nextInt();
		double Cm = sc.nextInt();
		double Cd = sc.nextInt();
		
		sc.close();
		double onlineCost = ((d - Of) * Od) + Oc;
		double classicCost = Cb + (d * Cm/Cs) + (d * Cd);
		
		if (onlineCost > classicCost) {
			
			System.out.println("Classic Taxi");
		} else {
			
			System.out.println("Online Taxi");
		}
	}

}
