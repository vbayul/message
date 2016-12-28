package org.vbayul.message;

import java.util.Locale;

public class SysLocale {
	
	public Locale getLocale() {

	    Locale locale = new Locale(
	    		System.getProperty("user.language"),
	    		System.getProperty("user.country"));

	    return locale;
	}
}
