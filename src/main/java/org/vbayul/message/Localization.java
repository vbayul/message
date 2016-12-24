package org.vbayul.message;

import java.util.Locale;

public class Localization {

	public String getLocale()
	{
		return Locale.getDefault().getLanguage();
	}
}
