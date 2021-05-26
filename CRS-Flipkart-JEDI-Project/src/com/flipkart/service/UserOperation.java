/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.exception.LoginException;

/**
 * @author dhruv
 * 
 */
public class UserOperation implements UserInterface{

	@Override
	public boolean login(int userId, String password) throws LoginException{
		// TODO Auto-generated method stub
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		boolean response=userDaoImpl.login(userId, password);
		if(response==false) {
			throw new LoginException(userId);
		}
		return response;
	}

	@Override
	public boolean updatePassword(int userId, String password){
		// TODO Auto-generated method stub
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		boolean response=userDaoImpl.updatePassword(userId, password);
		
		System.out.println(response);
		return response;		
	}

	@Override
	public ArrayList <Course> getCourseCatalog(int semester) {
		// TODO Auto-generated method stub
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		ArrayList <Course> courses=userDaoImpl.getCourseCatalog(semester);
		return courses;
	}	
	
	@Override
	public boolean getRole(int userId,int choice) throws LoginException{
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		boolean response=userDaoImpl.getRole(userId,choice);
		if(response==false) {
			throw new LoginException(userId);
		}
		return response;
	}
}
