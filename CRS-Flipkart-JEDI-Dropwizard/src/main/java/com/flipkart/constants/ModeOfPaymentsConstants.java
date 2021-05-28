package com.flipkart.constants;

public enum ModeOfPaymentsConstants {
	
	CARD,NET_BANKING;
	
	/**
	 * return the mode of payment used by user
	 * @param value
	 * @return the mode of payment enum
	 */
	public static ModeOfPaymentsConstants getModeofPayment(int value)
	{
		switch(value)
		{
			case 1:
				return ModeOfPaymentsConstants.CARD;
			case 2:
				return ModeOfPaymentsConstants.NET_BANKING;			
			default:
				return null;
				
		}
			
	}
	
}
