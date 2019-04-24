package com.ds.exceptions;

public class IncorrectArraySize extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6218081496600002745L;
	
	public String toString() {
		return "Array size must be greater than zero";
	}
}
