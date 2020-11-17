package keapser.chat.controller;

import java.util.regex.Pattern;

public final class PatternController {

	/*
	 * 
	 
		  ^           # start-of-string
	(?=.*[0-9])       # a digit must occur at least once
	(?=.*[a-z])       # a lower case letter must occur at least once
	(?=.*[A-Z])       # an upper case letter must occur at least once
	(?=.*[@#$%^&+=])  # a special character must occur at least once
	(?=\\S+$)          # no whitespace allowed in the entire string
	.{8,20}             # anything, at least eight places, at most 20
	$                 # end-of-string
		 */
	private final static String pwdRegex = "^(?=.*[0-9])"
							+"(?=.*[a-z])"
							+"(?=.*[A-Z])"
							+"(?=.*[@#$%^&+=])"
							+"(?=\\S+$)"
							+".{8,20}$";
	
	
	public static Boolean matchPassword(String pwd) {
		
		Pattern pwdPattern = java.util.regex.Pattern.compile(pwdRegex);
		return pwdPattern.matcher(pwdRegex).matches();
	}
	
	
	
	
	
	
}
