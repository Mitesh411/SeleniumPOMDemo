package com.medpay.qa.util;

import java.util.Base64;

/**
 * Helps to Decode the Base64 password
 * @author Mitesh Dandade
 * @version 1.0
 * @since 1.0
 */
public class DecodeUtils {
	
public DecodeUtils() {
		
	}
	
	/**
	 * Accepts and base64 string,decode and return to the caller
	 * @author Mitesh Dandade
	 * @param encodedString Base64 encoded string
	 * @return String Decoded base64 string
	 */
	
	
	public static String getDecodedString(String encodedString) {
		return new String(Base64.getDecoder().decode(encodedString.getBytes()));
	}
	

}
