package com.flipkart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.RegisteredCourse;
import com.flipkart.utils.*;

public class RegistrationDaoImpl implements RegistrationDaoInterface {
	
	public int addCourse(int courseId, int studentId) {

		try {
			Connection conn = DBUtil.getConnection();
			
			String sqlCheck = "select* from registered_course where studentId=? and courseId=?";
			PreparedStatement stmt = conn.prepareStatement(sqlCheck);
			
			ResultSet rs = stmt.executeQuery();
			if(rs!=null) {
				 return 0;
			}
			
			sqlCheck = "select COUNT(*) from registered_course where courseId=?";
			stmt = conn.prepareStatement(sqlCheck);
			rs =stmt.executeQuery();
			
			if(rs.getInt(1) >= 10) {
				return 1;
			}
			
			String sql1 = "select courseName from course where courseId=?";
			stmt = conn.prepareStatement(sql1);
			
			stmt.setInt(1, courseId);
			rs = stmt.executeQuery();
			
			String courseName = rs.getString(1);
			
			String sql="insert into registered_course values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			stmt.setString(3, "NA");
			stmt.setString(4, courseName);
			stmt.executeUpdate();
			
			stmt.close();
//		    conn.close();
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    
		return 2;
	}
	
	public boolean dropCourse(int courseId, int studentId) {
		
		try {
			Connection conn = DBUtil.getConnection();
			String sql="delete from registered_course where studentId=? and courseId=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			
			stmt.executeUpdate();
			
			stmt.close();
//		    conn.close();
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public ArrayList<RegisteredCourse> viewRegisteredCourses(int studentId, int semester) {
		
		try {
			Connection conn = DBUtil.getConnection();
			String sql="select studentId, courseId, grade, courseName from registered_course join course on courseId where studentId=? and semester=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, studentId);
			stmt.setInt(2, semester);
			
			ResultSet registeredCoursesSQL = stmt.executeQuery();
			
			ArrayList<RegisteredCourse> registeredCourses = new ArrayList<RegisteredCourse>();
			
			while(registeredCoursesSQL.next()) {
				int studentIdSQL = registeredCoursesSQL.getInt(1);
				int courseIdSQL = registeredCoursesSQL.getInt(2);
				String gradeSQL = registeredCoursesSQL.getString(3) == null ? "NA" : registeredCoursesSQL.getString(3);
				String courseName = registeredCoursesSQL.getString(4);
				
				RegisteredCourse registeredCourse = new RegisteredCourse(studentIdSQL, courseIdSQL, gradeSQL, courseName);
				registeredCourses.add(registeredCourse);
				return registeredCourses;
			}
			
			stmt.close();
		    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public RegisteredCourse getRegisteredCourse(int studentId, int courseId) {
		try {
			Connection conn = DBUtil.getConnection();
			String sql="select * from registered_course where studentId=? and courseId=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, studentId);
			stmt.setInt(2,  courseId);
			
			ResultSet registeredCoursesSQL = stmt.executeQuery();
				
			int studentIdSQL = registeredCoursesSQL.getInt(1);
			int courseIdSQL = registeredCoursesSQL.getInt(2);
			String gradeSQL = registeredCoursesSQL.getString(3) == null ? "NA" : registeredCoursesSQL.getString(3);
			String courseName = registeredCoursesSQL.getString(4);
			
			RegisteredCourse registeredCourse=new RegisteredCourse(studentIdSQL, courseIdSQL, gradeSQL, courseName);
			
		
			stmt.close();
		    conn.close();
		    
		    return registeredCourse;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
