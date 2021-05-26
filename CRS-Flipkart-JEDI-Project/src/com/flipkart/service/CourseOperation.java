package com.flipkart.service;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.exception.CourseAlreadyExistsException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorDoesNotExistException;

public class CourseOperation implements CourseInterface {
	
	private static Logger logger = Logger.getLogger(AdminOperation.class);
	
    public void modifyDetails(Course modifiedCourse)  throws CourseNotFoundException{
        AdminDaoInterface admin = AdminDaoImpl.getInstance();
        boolean ok = admin.modifyCourseDetails(modifiedCourse);
        if(ok)
            logger.info("Course details modified!");
        else {
            throw new CourseNotFoundException(modifiedCourse.getCourseId());
        }
    }

    public void allotProfessor(String professorId) throws ProfessorDoesNotExistException{
        logger.info("Professor allotted to course");
    }

    public String getCourseDetails()  throws CourseNotFoundException{
        logger.info("Details of the course are: ------------");
        return "";
    }
}
