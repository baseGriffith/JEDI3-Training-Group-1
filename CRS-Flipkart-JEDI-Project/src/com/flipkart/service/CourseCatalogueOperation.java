package com.flipkart.service;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.exception.CourseAlreadyExistsException;
import com.flipkart.exception.CourseNotFoundException;

public class CourseCatalogueOperation implements CourseCatalogueInterface {
	
	private static volatile CourseCatalogueOperation instance = null;
	 
    // private constructor
    private CourseCatalogueOperation() {
    }
 
    public static CourseCatalogueOperation getInstance() {
        if (instance == null) {
            synchronized (CourseCatalogueOperation.class) {
                instance = new CourseCatalogueOperation();
            }
        }
        return instance;
    }
	
	private static Logger logger = Logger.getLogger(AdminOperation.class);
	
    public void addCourse(Course newCourse) throws CourseAlreadyExistsException{
        AdminDaoInterface admin = AdminDaoImpl.getInstance();
        boolean ok = admin.addCourse(newCourse);
        if(ok)
           logger.info("Course successfully added!");
        else {
            throw new CourseAlreadyExistsException(newCourse.getCourseId());
        }
    }

    public void deleteCourse(int courseId) throws CourseNotFoundException{
        AdminDaoInterface admin = AdminDaoImpl.getInstance();
        boolean ok = admin.removeCourse(courseId);
        if(ok)
            logger.info("Course successfully added!");
        else {
            throw new CourseNotFoundException(courseId);
        }
        System.out.println("Course successfully deleted!");
    }
}
