/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Kaustubh
 *
 */
public class Grade {
	private char value;

	public char getValue() {
		System.out.println("Gets the grade for the registered course");
		return value;
	}

	public void setValue(char value) {
		System.out.println("Sets the grade for the registered course");
		this.value = value;
	}
	
}
