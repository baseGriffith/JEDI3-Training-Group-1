package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.exception.PaymentFailedException;
import com.flipkart.exception.ReportCardGenerationFailedException;

public interface StudInterface {
    /**
     *
     * @param rollNumber
     * @return
     */

    ReportCard viewReportCard(String rollNumber) throws ReportCardGenerationFailedException;

    /**
     *
     * @param rollNumber
     * @return
     */
    Course[] viewRegisteredCourses(String rollNumber);

    /**
     *
     * @param studentId
     * @return
     */
    boolean payFees(String studentId) throws PaymentFailedException;
}
