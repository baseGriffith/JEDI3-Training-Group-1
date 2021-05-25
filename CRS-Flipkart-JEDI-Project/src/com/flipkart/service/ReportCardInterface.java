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
	

	public void printReportCard() throws ReportCardGenerationFailedException;

	
}
