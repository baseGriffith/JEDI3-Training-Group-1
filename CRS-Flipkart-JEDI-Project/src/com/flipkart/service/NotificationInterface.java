/**
 * 
 */
package com.flipkart.service;

/**
 * Notifications services used for payment and registration notifications
 * @author JEDI-Group1
 *
 */
public interface NotificationInterface {
	
	/**
	 * prepares the message to be sent to the user
	 * @return String	 * 
	 */
	public String prepareMessage();
	
	/**
	 * notify the sudent based on the action result
	 * @return String
	 */
	public String notifyStudent();

}
