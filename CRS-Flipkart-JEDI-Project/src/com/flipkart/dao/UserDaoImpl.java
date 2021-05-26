package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.utils.DBUtil;

public class UserDaoImpl implements UserDaoInterface {

	@Override
	public boolean login(int userId, String password) {
		// TODO Auto-generated method stub		
		Connection conn = DBUtil.getConnection();		
		String validPassword="";
		try {
			String sql = "SELECT * FROM `crs-flipkart`.user where userId=(?)";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, userId);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			validPassword=rs.getString(4);
			System.out.println(validPassword);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return password.equals(validPassword);
	}

	@Override
	public boolean updatePassword(int userId, String newPassword) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		boolean passwordUpdated=true;
		try {
			String sql="UPDATE `crs-flipkart`.`user` SET `password` = ? WHERE (`userId` = ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, newPassword);
			statement.setInt(2, userId);
			
			statement.executeUpdate();			
			
		} catch (Exception e) {
			System.out.println(e);
			passwordUpdated=false;
		}
		return passwordUpdated;
	}

	@Override
	public ArrayList<Course> getCourseCatalog(int semester) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		ArrayList <Course> courses=new ArrayList<Course>();
		
		try {
			String sql = "SELECT * FROM course where semester=(?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, semester);
			
			ResultSet rs=statement.executeQuery();
			
			while(rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setDepartment(rs.getString(3));
				course.setProfessorId(rs.getInt(4));
				course.setSemester(rs.getInt(5));
				course.setCourseCode(rs.getString(6));

				courses.add(course);				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return courses;
	}

	@Override
	public boolean getRole(int userId, int choice) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		if(choice==1) {
			String sql = "SELECT * FROM `crs-flipkart`.student where studentId=(?)";			
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, userId);
				
				ResultSet rs=statement.executeQuery();
				return rs.next();
			}
			catch(Exception e) {
				return false;
			}			
		}else if(choice==2) {
			String sql = "SELECT * FROM `crs-flipkart`.professor where professorId=(?)";			
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, userId);
				
				ResultSet rs=statement.executeQuery();
				return rs.next();
			}
			catch(Exception e) {
				return false;
			}	
		}else if(choice==3) {
			String sql = "SELECT * FROM `crs-flipkart`.admin where adminId=(?)";			
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, userId);
				
				ResultSet rs=statement.executeQuery();
				return rs.next();
			}
			catch(Exception e) {
				return false;
			}	
		}	
		return false;
	}


}
