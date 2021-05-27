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
	
	public ArrayList <String> fetchMessages(int studentId);

}
