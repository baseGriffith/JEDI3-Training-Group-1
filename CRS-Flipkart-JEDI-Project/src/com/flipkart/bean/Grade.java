/**
 * 
 */
package com.flipkart.bean;

/**
 * @author JEDI-Group-1
 *
 */
public class Grade {
	private String value;

	public String getValue() {
		System.out.println("Gets the grade for the registered course");
		return value;
	}

	public void setValue(String value) {
		System.out.println("Sets the grade for the registered course");
		this.value = value;
	}
	
}
