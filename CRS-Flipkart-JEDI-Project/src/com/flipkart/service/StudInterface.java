package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;

public interface StudInterface {
    /**
     *
     * @param rollNumber
     * @return
     */

    ReportCard viewReportCard(String rollNumber);

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
    boolean payFees(String studentId);
}
