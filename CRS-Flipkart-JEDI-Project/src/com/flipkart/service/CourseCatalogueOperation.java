package com.flipkart.service;

/**
 * @author JEDI-Group-1
 */
import com.flipkart.bean.Course;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.exception.CourseAlreadyExistsException;
import com.flipkart.exception.CourseNotFoundException;

public class CourseCatalogueOperation implements CourseCatalogueInterface {
    public void addCourse(Course newCourse) throws CourseAlreadyExistsException{
        AdminDaoInterface admin = new AdminDaoImpl();
        boolean ok = admin.addCourse(newCourse);
        if(ok)
            System.out.println("Course successfully added!");
        else {
            throw new CourseAlreadyExistsException(newCourse.getCourseId());
        }
    }

    public void deleteCourse(int courseId) throws CourseNotFoundException{
        AdminDaoInterface admin = new AdminDaoImpl();
        boolean ok = admin.removeCourse(courseId);
        if(ok)
            System.out.println("Course successfully added!");
        else {
            throw new CourseNotFoundException(courseId);
        }
        System.out.println("Course successfully deleted!");
    }
}
