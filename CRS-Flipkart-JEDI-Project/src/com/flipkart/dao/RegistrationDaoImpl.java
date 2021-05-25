package com.flipkart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.RegisteredCourse;
import com.flipkart.utils.*;

public class RegistrationDaoImpl implements RegistrationDaoInterface {
	
	public boolean addCourse(int courseId, int studentId) {

		try {
			Connection conn = DBUtil.getConnection();
			String sql="insert into registered_course values(?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			stmt.setString(3, "NA");
			stmt.executeUpdate();
			
			stmt.close();
//		    conn.close();
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    
		return true;
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
	public ArrayList<RegisteredCourse> viewRegisteredCourses(int studentId) {
		
		try {
			Connection conn = DBUtil.getConnection();
			String sql="select * from registered_course where studentId=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, studentId);
			
			ResultSet registeredCoursesSQL = stmt.executeQuery();
			
			ArrayList<RegisteredCourse> registeredCourses = new ArrayList<RegisteredCourse>();
			
			while(registeredCoursesSQL.next()) {
				int studentIdSQL = registeredCoursesSQL.getInt(1);
				int courseIdSQL = registeredCoursesSQL.getInt(2);
				String gradeSQL = registeredCoursesSQL.getString(3) == null ? "NA" : registeredCoursesSQL.getString(3);
				
				RegisteredCourse registeredCourse = new RegisteredCourse(studentIdSQL, courseIdSQL, gradeSQL);
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
	
	public static void main(String[] args) {
		RegistrationDaoInterface r = new RegistrationDaoImpl();
		r.dropCourse(1, 1);
		r.addCourse(1, 1);
//		if(r.addCourse(1 , 1)) {
			ArrayList<RegisteredCourse> rs= r.viewRegisteredCourses(1);
			for(RegisteredCourse reg: rs) {
				System.out.println(reg.getStudentId());
			}
//		}
	}
	
}
