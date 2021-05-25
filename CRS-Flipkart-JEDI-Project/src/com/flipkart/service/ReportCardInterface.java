/**
 * 
 */
package com.flipkart.service;

import com.flipkart.exception.ReportCardGenerationFailedException;

/**
 * @author Kaustubh
 *
 */
public interface ReportCardInterface{
	
	
	/**
	 * Get the report card for the student
	 * @throws ReportCardGenerationFailedException
	 */
	public void printReportCard() throws ReportCardGenerationFailedException;

	
}
