/**
 * 
 */
package com.flipkart.service;

import com.flipkart.exception.ReportCardGenerationFailedException;

/**
 * @author JEDI-Group-1
 * 
 */
public interface ReportCardInterface{
	
	
	/**
	 * Get the report card for the student
	 * @throws ReportCardGenerationFailedException
	 */
	public boolean printReportCard(int studentId, int semester) throws ReportCardGenerationFailedException;

	
}
