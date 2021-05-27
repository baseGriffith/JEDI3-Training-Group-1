package com.flipkart.dao;

import java.util.ArrayList;

/**
 * Access notification database
 * @author JEDI-Group1
 *
 */
public interface NotificationDaoInterface {
	/**
	 * fetch all the notifications for the given studentId
	 * @param studentId
	 * @return String
	 */
	public ArrayList<String> fetchMessages(int studentId);
	
	/**
	 * delete the notification message from the database
	 * @param notificationId
	 * @return
	 */
	public boolean deleteMessage(int notificationId);
	
	/**
	 * used by other classes to insert notification messages in the database
	 * @param message
	 * @param studentId
	 * @return
	 */
	public boolean insertNotification(String message,int studentId);
}
