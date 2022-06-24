package com.dia.helper;

public class CommonUtil {
	public static String nullToValue(String object, String value) {
		if(object == null || object.equals(""))
			return value;
		else
			return object;
	}
	
	public static String nullToValue(String object) {
		if(object == null || object.equals(""))
			return "0";
		else
			return object;
	}
}
