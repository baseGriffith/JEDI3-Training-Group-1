package com.flipkart.constant;

public enum RoleConstants {
	ADMIN,PROFESSOR,STUDENT;	
	
	/**
	 * Role enum value is returned
	 * @param role
	 * @return Role object
	 */
	public static RoleConstants convertName(String role)
	{
		if(role.equalsIgnoreCase("STUDENT"))
			return RoleConstants.STUDENT;
		else if(role.equalsIgnoreCase("PROFESSOR"))
			return RoleConstants.PROFESSOR;
		else if(role.equalsIgnoreCase("ADMIN"))
			return RoleConstants.ADMIN;
		
		return null;
	}
}
