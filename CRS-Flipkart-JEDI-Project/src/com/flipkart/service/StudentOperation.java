package com.flipkart.service;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.client.MainMenu;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.exception.PaymentFailedException;
import com.flipkart.exception.ReportCardGenerationFailedException;
import com.flipkart.bean.Student;
import com.flipkart.exception.StudentAlreadyExistsException;
import com.flipkart.exception.StudentRegistrationFailedException;
import org.apache.log4j.Logger;

/**
 * Class used for services provided to student users
 * @author JEDI-Group1
 *
 */
public class StudentOperation implements StudInterface{
    private static Logger logger = Logger.getLogger(StudentOperation.class);

    @Override
    public ReportCard viewReportCard(String rollNumber) throws ReportCardGenerationFailedException{
        return null;
    }

    @Override
    public ArrayList<Course> viewRegisteredCourses(int studentId) {
    	StudentDaoImpl s=new StudentDaoImpl();
    	ArrayList<Course> courses = s.viewRegisteredCourses(studentId);
    	return courses;
    }

    @Override
    public boolean payFees(int studentId,int amount,String mode) throws PaymentFailedException{
        // implement whole frees payment function
    	StudentDaoImpl s=new StudentDaoImpl();
    	boolean feeStatus=s.payFees(studentId, amount, mode);
    	if(feeStatus==false) {
    		throw new PaymentFailedException(studentId);
    	}
        return feeStatus;
    }

    @Override

    public boolean register(Student student) throws StudentAlreadyExistsException, StudentRegistrationFailedException {
        try {
            StudentDaoInterface studentDao = new StudentDaoImpl();
            int flag = studentDao.register(student);
            if (flag == 0) throw new StudentAlreadyExistsException(student.getUserId());
            else if (flag == 2) throw new StudentRegistrationFailedException(student.getUserId());

            return true;

        } 
         catch (Exception e) {
            logger.info(e.getMessage());

            return false;
        }
    }

    public Student getStudent(int studentId) {
        StudentDaoImpl s = new StudentDaoImpl();
        Student ret = s.getStudent(studentId);
        return ret;
    }
    public ArrayList<Student> fetchAllStudents() {
        ArrayList<Student> st = new ArrayList<Student>();
        StudentDaoImpl sdi = new StudentDaoImpl();
        return sdi.fetchAllStudents();
    }

    public boolean removeStudent(int studentId) {
        StudentDaoImpl sdi = new StudentDaoImpl();
        return sdi.removeStudent(studentId);
    }

    @Override
    public void approveStudent(int studentId) {
        StudentDaoImpl sdi = new StudentDaoImpl();
        sdi.approveStudent(studentId);
    }
}
