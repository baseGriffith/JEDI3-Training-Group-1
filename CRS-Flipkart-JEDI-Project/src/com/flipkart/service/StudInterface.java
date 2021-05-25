package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.exception.PaymentFailedException;
import com.flipkart.exception.ReportCardGenerationFailedException;

public interface StudInterface {
    /**
     * Gets the reportCard for the semester
     * @param rollNumber
     * @throws ReportCardGenerationFailedException
     * @return ReportCard
     */

    ReportCard viewReportCard(String rollNumber) throws ReportCardGenerationFailedException;

    /**
     *View the courses registered during this semester
     * @param rollNumber
     * @return Course[]
     */
    Course[] viewRegisteredCourses(String rollNumber);

    /**
     * Pay fees after the regsistration 
     * @param studentId
     * @throws PaymentFailedException
     * @return boolean indicating if payment was successful
     */
    boolean payFees(String studentId) throws PaymentFailedException;
}
