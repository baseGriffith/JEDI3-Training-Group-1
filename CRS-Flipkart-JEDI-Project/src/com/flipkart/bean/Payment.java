/**
 * 
 */
package com.flipkart.bean;

import java.util.Date;

/**
 * Class depicting payment properties and simple methods
 * @author JEDI-Group1
 *
 */
public class Payment {

	private float amount;
	private int studentId;
	private Date date;
	
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
}
