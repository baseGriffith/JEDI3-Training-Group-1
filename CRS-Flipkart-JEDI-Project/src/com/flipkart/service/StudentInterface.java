package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;

public interface StudentInterface {
    /**
     *
     * @param rollNumber
     * @return
     */
    ReportCard viewReportCard(int rollNumber);

    /**
     *
     * @param studentId
     * @return
     */
    Course[] viewRegisteredCourses(String studentId);

    /**
     *
     * @param studentId
     * @return
     */
    boolean payFes(String studentId);
}