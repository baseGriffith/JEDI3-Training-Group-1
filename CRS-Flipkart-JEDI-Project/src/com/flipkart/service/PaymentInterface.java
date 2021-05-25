package com.flipkart.service;

import com.flipkart.exception.PaymentFailedException;

/**
 * @author dhruv
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
	public boolean makePayment(int studentId, float amount) throws PaymentFailedException;

}
