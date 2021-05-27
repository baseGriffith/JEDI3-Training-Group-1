/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

/**
 * Notifications services used for payment and registration notifications
 * @author JEDI-Group1
 *
 */
public interface NotificationInterface {
	
	/**
	 * fetch messages for the student
	 * @param studentId
	 * @return
	 */
	public ArrayList <String> fetchMessages(int studentId);
	
	
}
