package com.util;

public class NullUtil {
	
	public static boolean isNullOrEmpty(Object object) {
		if(object == null || object.equals("") | object == null) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(String s) {
		if(s == null || s.equals("") || s.trim().equals("")) {
			return true;
		}
		return false;
	}
}
