package com.flipkart.service;

import java.time.LocalDate;

import com.flipkart.constants.NotificationConstants;
import com.flipkart.dao.NotificationDaoImpl;
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
		
		LocalDate localDate = LocalDate.now();

    	StudentDaoImpl s= StudentDaoImpl.getInstance();
    	NotificationDaoImpl n=NotificationDaoImpl.getInstance();
    	
    	boolean notifyStatus=n.insertNotification("PAYMENT_SUCCESFUL on"+localDate, studentId);
    	boolean feeStatus=s.payFees(studentId, amount, mode);
    	
    	    	
    	if(feeStatus==false) {
    		n.insertNotification("PAYMENT_FAILED on"+localDate, studentId);
    		throw new PaymentFailedException(studentId);
    	}
        return feeStatus;
    }   
	
}
