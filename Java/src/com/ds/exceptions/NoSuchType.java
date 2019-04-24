/**
 * 
 */
package com.ds.exceptions;

/**
 * @author Allabakash
 *
 */
public class NoSuchType extends Exception {

	private String type;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7500473832885285747L;

	public NoSuchType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return "No Such Sorting Type :: " + this.type;
	}
}
