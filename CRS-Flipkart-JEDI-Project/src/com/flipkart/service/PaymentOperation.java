package com.flipkart.service;

import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.exception.PaymentFailedException;

public class PaymentOperation implements PaymentInterface{

	private static volatile PaymentOperation instance = null;
	 
    // private constructor
    private PaymentOperation() {
    }
 
    public static PaymentOperation getInstance() {
        if (instance == null) {
            synchronized (PaymentOperation.class) {
                instance = new PaymentOperation();
            }
        }
        return instance;
    }
	
	@Override
    public boolean payFees(int studentId,int amount,String mode) throws PaymentFailedException{
        // implement whole frees payment function
    	StudentDaoImpl s=StudentDaoImpl.getInstance();
    	boolean feeStatus=s.payFees(studentId, amount, mode);
    	if(feeStatus==false) {
    		throw new PaymentFailedException(studentId);
    	}
        return feeStatus;
    }   
	
}
