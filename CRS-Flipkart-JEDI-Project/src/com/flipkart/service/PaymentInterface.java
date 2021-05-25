package com.flipkart.service;

import com.flipkart.exception.PaymentFailedException;

public interface PaymentInterface {
	
	public boolean makePayment(int studentId, float amount) throws PaymentFailedException;

}
