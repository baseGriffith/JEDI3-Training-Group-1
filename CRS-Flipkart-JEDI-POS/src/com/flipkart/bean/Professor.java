/**
 * 
 */
package com.flipkart.bean;

/**
 * Professor class which derives properties from User class
 * @author JEDI-Group1
 *
 */
public class Professor extends User{
	
	private String department;
	
	public Professor() {
		
	}
	
	public Professor(int userId) {
		super(userId);
	}
	
	public Professor(String department) {
		super();
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}

}
