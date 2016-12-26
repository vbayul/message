package org.vbayul.message;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Resources {
	
	private static final Logger log = LogManager.getLogger("file");
	
	public ResourceBundle getBundels(String lang)
	{
		log.info("Starting getBundels method");
		
		log.info("Set language " + lang);		
		Locale.setDefault(new Locale(lang));
		
		log.info("Get resource");		
		ResourceBundle bundles = ResourceBundle.getBundle("message");
		
		log.info("Ending getBundels method");
		return bundles;
	}
}