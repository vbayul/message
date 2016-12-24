package org.vbayul.message;

import java.util.Date;
import java.util.ResourceBundle;

public class Main {

	public static void main(String[] args) {
		
		Keys key = new Keys();
		String keys = key.getKey(new Date());
		
		Localization loc = new Localization();
		
		String lang = loc.getLocale();
		
		Resources rs = new Resources();
		ResourceBundle rb = rs.getBundels(lang);
		String message = rb.getString(keys);
		
		System.out.println(message);
	}
}
