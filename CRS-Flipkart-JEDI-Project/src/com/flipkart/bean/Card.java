/**
 * 
 */
package com.flipkart.bean;

import java.util.Date;

/**
 * @author lenovo
 *
 */
public class Card extends Payment {

	private int cardNo;
	private Date doe;

	public int getCardNo() {
		return cardNo;
	}
	
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	
	public Date getDoe() {
		return doe;
	}
	
	public void setDoe(Date doe) {
		this.doe = doe;
	}
	
	
	
}
