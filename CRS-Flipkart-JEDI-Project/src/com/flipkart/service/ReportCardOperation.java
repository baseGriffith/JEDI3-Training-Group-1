/**
 * 
 */
package com.flipkart.service;

import com.flipkart.exception.ReportCardGenerationFailedException;

/**
 * @author Kaustubh
 *
 */
public class ReportCardOperation implements ReportCardInterface{
	
	@Override

	public void printReportCard() throws ReportCardGenerationFailedException {

		System.out.println("Print the report card with all the details");
	}
	
}
