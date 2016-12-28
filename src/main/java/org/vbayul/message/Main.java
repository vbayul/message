package org.vbayul.message;

import java.time.LocalTime;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

	private static final Logger log = LogManager.getLogger("file");
	
	public static void main(String[] args) {
		
		log.info("Starting program");
		Resources resources = new Resources();		
		Keys keys = new Keys();
		SysLocale locale = new SysLocale();		
		String key = keys.getKey(LocalTime.now());
		log.info("Get key string");

		String lang = locale.getLocale().getLanguage();
		String country = locale.getLocale().getCountry();
		log.info("Get language " + lang +" and country"+ country);
		
		ResourceBundle bundels = resources.getBundels(lang, country);
		log.info("Get bundels by language");
		
		String message = bundels.getString(key);
		log.info("Get message by key");
		
		log.info("Output message");	
		System.out.println(message);
		log.info("Ending program");
	}
}
