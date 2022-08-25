package com.carparkingsystem.validators;

public class IntegerValidator {

	public static boolean isInteger(String number) {
		try 
		{ 
			Integer.parseInt(number); 
			return true;
		}  
		catch (NumberFormatException e)  
		{ 
			return false;
		} 
	}


}
