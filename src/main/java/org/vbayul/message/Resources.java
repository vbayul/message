package org.vbayul.message;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Resources {
	
	private static final Logger log = LogManager.getLogger("file");
	
	public ResourceBundle getBundels(String lang, String country)
	{
		log.info("Starting getBundels method");
		ResourceBundle messages ;
		
		if (lang.equals(""))
		{	
			log.info("Set language = " + lang + " and  country = ");
			Locale currentLocale = new Locale(lang, country);
			
			log.info("Get resource");		
			messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		}
		else
			messages = ResourceBundle.getBundle("MessagesBundle");
		
		log.info("Ending getBundels method");
		return messages;
	}
}