package com.flipkart.service;

/**
 * @author JEDI-Group-1
 * 
 */
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.exception.PaymentFailedException;

public class PaymentOperation implements PaymentInterface{

	@Override
    public boolean payFees(int studentId,int amount,String mode) throws PaymentFailedException{
        // implement whole frees payment function
    	StudentDaoImpl s=new StudentDaoImpl();
    	boolean feeStatus=s.payFees(studentId, amount, mode);
    	if(feeStatus==false) {
    		throw new PaymentFailedException(studentId);
    	}
        return feeStatus;
    }   
	
}
