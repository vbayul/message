package org.vbayul.message;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

	public static void main(String[] args) {
		
		Resources resources = new Resources();		
		Keys keys = new Keys();
		
		String key = keys.getKey(new Date());
		String lang = Locale.getDefault().getLanguage();
		ResourceBundle bundels = resources.getBundels(lang);
		
		String message = bundels.getString(key);
		System.out.println(message);
	}
}
