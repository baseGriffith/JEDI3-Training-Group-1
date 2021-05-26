package com.flipkart.service;

import org.apache.log4j.Logger;

public class NotificationOperation implements NotificationInterface {
	
	private static volatile NotificationOperation instance = null;
	 
    // private constructor
    private NotificationOperation() {
    }
 
    public static NotificationOperation getInstance() {
        if (instance == null) {
            synchronized (NotificationOperation.class) {
                instance = new NotificationOperation();
            }
        }
        return instance;
    }
	
	private static Logger logger = Logger.getLogger(AdminOperation.class);
	
	@Override
	public String notifyStudent() {
		logger.info("Notify the student with the appropriate message");
		return null;
	}

	@Override
	public String prepareMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
