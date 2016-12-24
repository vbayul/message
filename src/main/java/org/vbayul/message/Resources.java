package org.vbayul.message;

import java.util.Locale;
import java.util.ResourceBundle;

public class Resources {
	
	public ResourceBundle getBundels(String lang)
	{
		Locale.setDefault(new Locale(lang));
		ResourceBundle bundles = ResourceBundle.getBundle("message");
		return bundles;
	}
}