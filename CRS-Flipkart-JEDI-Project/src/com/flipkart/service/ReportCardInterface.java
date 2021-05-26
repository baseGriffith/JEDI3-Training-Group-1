/**
 * 
 */
package com.flipkart.service;

import com.flipkart.exception.ReportCardGenerationFailedException;

/**
 * Class used for services for report card
 * @author JEDI-Group1
 *
 */
public interface ReportCardInterface{
	
	
	/**
	 * 
	 * @param studentId
	 * @param semester
	 * @return whether the report card has been generated
	 * @throws ReportCardGenerationFailedException
	 */
	public boolean printReportCard(int studentId, int semester) throws ReportCardGenerationFailedException;

	
}
