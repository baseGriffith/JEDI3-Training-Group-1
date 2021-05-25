/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.exception.LoginException;

/**
 * @author dhruv
 *
 */
public class UserImpl implements UserInterface{

	@Override
	public boolean login(int userId, String password) throws LoginException{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updatePassword(int userId, String password) throws LoginException{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Course[] getCourseCatalog(int semester) {
		// TODO Auto-generated method stub
		return null;
	}

}
