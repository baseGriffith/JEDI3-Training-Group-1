package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyBeingTaughtException;
import com.flipkart.service.AdminOperation;
import com.flipkart.utils.DBUtil;
import org.apache.log4j.Logger;

public class ProfessorDaoImpl implements ProfessorDaoInterface{
	private static Logger logger = Logger.getLogger(ProfessorDaoImpl.class);

    @Override
    public void signupCourse(int professorId, int courseId) throws CourseAlreadyBeingTaughtException {
        try {
            Connection conn = DBUtil.getConnection();
            
            
            String sql ="SELECT * FROM `crs-flipkart`.course where courseId=(?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            
			statement = conn.prepareStatement(sql);
			statement.setInt(1, courseId);
			
            ResultSet rs = statement.executeQuery();
            rs.next();
            if(rs.getInt("professorId") == -1) {
            
                sql = "UPDATE `crs-flipkart`.`course` SET `professorId` = ? WHERE (`courseId` = ?)";
                statement = conn.prepareStatement(sql);
                statement.setInt(1, professorId);
                statement.setInt(2, courseId);
                
                statement.executeUpdate();
            }
            else {
                // implement something in case already  exist, throw exception or something
            	throw new CourseAlreadyBeingTaughtException(courseId,professorId);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void gradeCourse(int studentId, int courseId, String grade) {
        try {
            Connection con = DBUtil.getConnection();
            Statement stmt = con.createStatement();
            String sql = "update RegisteredCourses set grade = '" + grade +
                    "' where courseId = " + courseId + " and studentId = " + studentId;
            stmt.executeUpdate(sql);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Student> getEnrolledStudents(int courseId) {
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Integer> studentIds=new ArrayList<Integer>();
        try {
			Connection conn = DBUtil.getConnection();
			String sql = "SELECT * FROM `crs-flipkart`.registeredcourses where courseId=(?)";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, courseId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				studentIds.add(rs.getInt(2));
			}			
			

			for (int i = 0; i < studentIds.size(); ++i) {
				sql = "SELECT * FROM `crs-flipkart`.user where userId=(?)";
				statement = conn.prepareStatement(sql);
				statement.setInt(1, studentIds.get(i));

				rs = statement.executeQuery();
				rs.next();
				Student student=new Student();
				student.setUserId(rs.getInt(1));
				student.setName(rs.getString(2));

				students.add(student);				
				//conn.close();
			}

		} catch (Exception ex) {
			logger.info(ex);
		}
        return students;
    }

	@Override
	public ArrayList<Course> getProfessorRegisteredCourses(int professorId) {
		// TODO Auto-generated method stub
		
		ArrayList<Course> courses = new ArrayList<Course>();		

		try {
			Connection conn = DBUtil.getConnection();
			String sql = "SELECT * FROM `crs-flipkart`.course where professorId=(?)";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, professorId);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setDepartment(rs.getString(3));
				course.setProfessorId(rs.getInt(4));
				course.setSemester(rs.getInt(5));
				course.setCourseCode(rs.getString(6));

				courses.add(course);
				//System.out.println("dibe");
			}		

		} catch (Exception ex) {
			logger.info(ex);
		}
		
		return courses;
	}
}
