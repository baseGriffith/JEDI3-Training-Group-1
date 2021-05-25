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

	private String branch;	
	private Date joiningDate;
	
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
