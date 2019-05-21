package com.ds.hackerrank;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Coordinate {

	/**
	    * This is the function to convert latitude and longitude to decimal format from degrees minutes and seconds.
	    * @param degrees The degrees in a coordinate
	    * @param minutes The minutes in a coordinate
	    * @param seconds The seconds in a coordinate
	    * @param direction The direction of a coordinate. Value is only 1 or -1
	    * @return
	    */
	    public static double dms2dd(double degrees, double minutes, double seconds, int direction) {
	        double dd = degrees + (minutes / 60.0) + (seconds / 3600.0);
	        DecimalFormat d = new DecimalFormat("#.####");
	        return Double.valueOf(d.format(dd));
	    }


	    public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	        Scanner sc = new Scanner(System.in);
	        
	        while(sc.hasNext()) {
	            String s = sc.next();
	            
	        }
	    }
}
