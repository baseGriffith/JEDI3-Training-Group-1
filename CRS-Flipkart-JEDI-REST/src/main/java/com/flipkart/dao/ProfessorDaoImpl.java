package com.flipkart.dao;

/**
 * @author JEDI-Group-1
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.exception.CourseAlreadyBeingTaughtException;
import com.flipkart.utils.DBUtil;

public class ProfessorDaoImpl implements ProfessorDaoInterface{
	
	private static Logger logger = Logger.getLogger(ProfessorDaoImpl.class);
	
	private static volatile ProfessorDaoImpl instance = null;
	 
    // private constructor
    private ProfessorDaoImpl() {
    }
 
    public static ProfessorDaoImpl getInstance() {
        if (instance == null) {
            synchronized (ProfessorDaoImpl.class) {
                instance = new ProfessorDaoImpl();
            }
        }
        return instance;
    }
	
	
    @Override
    public void signupCourse(int professorId, int courseId) throws CourseAlreadyBeingTaughtException {
        try {
            Connection conn = DBUtil.getConnection();
            
            String sql = SQLQueriesConstants.VIEW_COURSE_QUERY;
            PreparedStatement statement = conn.prepareStatement(sql);
            
			statement = conn.prepareStatement(sql);
			statement.setInt(1, courseId);
			
            ResultSet rs = statement.executeQuery();
            rs.next();
            if(rs.getInt("professorId") == -1) {
            
                sql = SQLQueriesConstants.ADD_COURSE_TO_PROFESSOR_QUERY;
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
			String sql = SQLQueriesConstants.VIEW_REGISTERED_COURSE_QUERY;
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, courseId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				studentIds.add(rs.getInt(2));
			}			
			

			for (int i = 0; i < studentIds.size(); ++i) {
				sql = SQLQueriesConstants.VIEW_USER_QUERY;
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
			String sql = SQLQueriesConstants.VIEW_PROFESSOR_COURSES_QUERY;
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
			}		

		} catch (Exception ex) {
			logger.info(ex);
		}
		
		return courses;
	}
}
