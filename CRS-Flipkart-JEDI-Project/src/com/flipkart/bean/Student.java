/**
 * 
 */
package com.flipkart.bean;

import java.util.Date;

/**
 * @author dhruv
 *
 */
public class Student extends User{

	private String rollNumber;
	private String branch;	
	private Date joiningDate;

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	public String getBranch() {
		return branch;
	}
	
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public Date getJoiningDate() {
		return joiningDate;
	}
	
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	

}
