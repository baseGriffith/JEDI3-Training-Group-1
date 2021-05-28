package com.flipkart.dao;

/**
 * @author JEDI-Group-1
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtil;

public class StudentDaoImpl implements StudentDaoInterface {
	
	private static volatile StudentDaoImpl instance = null;
	 
    // private constructor
    private StudentDaoImpl() {}
 
    public static StudentDaoImpl getInstance() {
        if (instance == null) {
            synchronized (StudentDaoImpl.class) {
                instance = new StudentDaoImpl();
            }
        }
        return instance;
    }
	
	private static Logger logger = Logger.getLogger(StudentDaoImpl.class);
	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		Student student = new Student();
		Connection conn = DBUtil.getConnection();
		try {

			String sql = SQLQueriesConstants.VIEW_STUDENT_QUERY;
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, studentId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				//logger.info(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + rs.getInt(4));
				student.setSemester(rs.getInt("semester"));
			}

			sql = SQLQueriesConstants.VIEW_USER_QUERY;
			statement = conn.prepareStatement(sql);
			statement.setInt(1, studentId);

			rs = statement.executeQuery();

			while (rs.next()) {
				student.setUserId(studentId);
				student.setName(rs.getString("name"));
				student.setAddress(rs.getString("address"));
				student.setPassword(rs.getString("password"));
			}

			//conn.close();

		} catch (Exception ex) {
			logger.info("Exception occured");
		}

		return student;

	}

	public int register(Student student) {
		try {
			Connection conn = DBUtil.getConnection();
			String sql = SQLQueriesConstants.COUNT_USER_WITH_ID_QUERY;
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, student.getUserId());

			ResultSet rs = statement.executeQuery();
			rs.next();
			if(rs.getInt(1) > 0){
				logger.info(rs.getInt(1));
				return 0;
			}

			sql = SQLQueriesConstants.ADD_USER_QUERY;
			statement = conn.prepareStatement(sql);


			statement.setInt(1, student.getUserId());
			statement.setString(2, student.getName());
			statement.setString(3, student.getAddress());
			statement.setString(4, student.getPassword());

			statement.executeUpdate();

			sql = SQLQueriesConstants.ADD_STUDENT_QUERY;
			statement = conn.prepareStatement(sql);

			statement.setInt(1, student.getUserId());
			statement.setString(2, student.getBranch());
			statement.setInt(3, student.getSemester());

			statement.executeUpdate();

			return 1;
		} catch(Exception e){
			logger.info(e.getMessage());
			return 2;
		}
	}

	@Override
	public boolean payFees(int studentId, int amount, String mode) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		boolean paymentSuccess = true;
		try {
			String sql = SQLQueriesConstants.PAY_FEES_QUERY;
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, amount);
			statement.setInt(2, studentId);
			statement.setString(3, mode);

			statement.executeUpdate();
			statement.close();
			//conn.close();
		} catch (SQLException se) {
			logger.warn(se.getMessage());
			paymentSuccess = false;
		}
		return paymentSuccess;
	}

	@Override
	public ArrayList<Course> viewRegisteredCourses(int studentId) {
		// TODO Auto-generated method stub
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<Integer> courseIds = new ArrayList<Integer>();

		try {
			Connection conn = DBUtil.getConnection();
			String sql = SQLQueriesConstants.VIEW_STUDENT_REGISRETED_COURSE_QUERY;
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, studentId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				courseIds.add(rs.getInt(2));
			}			
			

			for (int i = 0; i < courseIds.size(); ++i) {
				sql = SQLQueriesConstants.VIEW_COURSE_QUERY;
				statement = conn.prepareStatement(sql);
				statement.setInt(1, courseIds.get(i));

				rs = statement.executeQuery();
				rs.next();
				Course course = new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setDepartment(rs.getString(3));
				course.setProfessorId(rs.getInt(4));
				course.setSemester(rs.getInt(5));
				course.setCourseCode(rs.getString(6));

				courses.add(course);				
				//conn.close();
			}

		} catch (Exception ex) {
			logger.info(ex);
		}

		return courses;
	}

	public ArrayList<Student> fetchAllStudents() {
		ArrayList<Student> st = new ArrayList<Student>();
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "SELECT * FROM `crs-flipkart`.student where isApproved is false";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setUserId(rs.getInt("studentId"));
				student.setIsApproved(rs.getBoolean("isApproved"));
				student.setSemester(rs.getInt("semester"));
				student.setBranch(rs.getString("branch"));
				st.add(student);
			}
		}
		catch (Exception e) {
			logger.info(e.getMessage());
		}
		return st;
	}

	public boolean removeStudent(int studentId) {
		boolean ok = true;
		try {
			Connection con = DBUtil.getConnection();
			Statement stmt = con.createStatement();
			String sql = "delete from student where studentId = " + studentId;
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			ok = false;
			System.out.println(e.getMessage());
		}
		return ok;
	}
	
	@Override
	public void approveStudent(int studentId) {
		try {
			Connection con = DBUtil.getConnection();
			Statement stmt = con.createStatement();
			String sql = "update student set isApproved = true where studentId = " + studentId;
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
