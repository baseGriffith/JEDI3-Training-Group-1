package com.flipkart.service;

import com.flipkart.exception.PaymentFailedException;

public class PaymentImpl implements PaymentInterface{

	@Override
	public boolean makePayment(int studentId, float amount) throws PaymentFailedException {
		// TODO Auto-generated method stub
		System.out.println("Payment Failed");
		return false;
	}
	
}
