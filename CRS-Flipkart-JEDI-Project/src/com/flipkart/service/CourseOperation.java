package com.flipkart.service;

/**
 * @author JEDI-Group-1
 */
import com.flipkart.bean.Course;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.exception.CourseAlreadyExistsException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorDoesNotExistException;

public class CourseOperation implements CourseInterface {
    public void modifyDetails(Course modifiedCourse)  throws CourseNotFoundException{
        AdminDaoInterface admin = new AdminDaoImpl();
        boolean ok = admin.modifyCourseDetails(modifiedCourse);
        if(ok)
            System.out.println("Course details modified!");
        else {
            throw new CourseNotFoundException(modifiedCourse.getCourseId());
        }
    }

    public void allotProfessor(String professorId) throws ProfessorDoesNotExistException{
        System.out.println("Professor allotted to course");
    }

    public String getCourseDetails()  throws CourseNotFoundException{
        System.out.println("Details of the course are: ------------");
        return "";
    }
}
