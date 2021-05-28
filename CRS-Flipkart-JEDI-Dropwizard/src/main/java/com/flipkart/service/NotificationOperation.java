package com.flipkart.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.dao.NotificationDaoImpl;

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
	
	/**
	 * return the messages for the user
	 * @param studentId
	 * @return list of messages
	 */
	public ArrayList <String> fetchMessages(int studentId){
		ArrayList <String> messages=null;
		try {
			NotificationDaoImpl notificationDaoImpl=NotificationDaoImpl.getInstance();
			messages=notificationDaoImpl.fetchMessages(studentId);			
		}catch(Exception e) {
			logger.info(e);
		}
		return messages;
	}
	
}
