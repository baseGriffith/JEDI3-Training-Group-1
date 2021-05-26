package com.flipkart.constant;

public enum ModeOfPaymentConstants {
	
	CARD,NET_BANKING;
	
	/**
	 * return the mode of payment used by user
	 * @param value
	 * @return the mode of payment enum
	 */
	public static ModeOfPaymentConstants getModeofPayment(int value)
	{
		switch(value)
		{
			case 1:
				return ModeOfPaymentConstants.CARD;
			case 2:
				return ModeOfPaymentConstants.NET_BANKING;			
			default:
				return null;
				
		}
			
	}
	
}
