package com.flipkart.service;

import com.flipkart.exception.PaymentFailedException;

/**
 * @author JEDI-Group-1
 * 
 */
public interface PaymentInterface {	
	
	/**
	 * Pay specify amount for registration based on student id
	 * @param studentId
	 * @param amount
	 * @return
	 * @throws PaymentFailedException
	 */
	public boolean payFees(int studentId,int amount,String mode) throws PaymentFailedException;

}
