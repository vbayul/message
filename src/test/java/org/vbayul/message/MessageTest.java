package org.vbayul.message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;
import junit.framework.TestCase;

public class MessageTest extends TestCase {

	@Test
	public void testLocalizationRU()
	{
		Locale.setDefault(new Locale("ru", "RU"));
		
		Localization local = new Localization();
		String lang =  local.getLocale();
		assertEquals("ru", lang);
	}
	
	@Test
	public void testLocalizationFR()
	{
		Locale.setDefault(new Locale("fr", "FR"));
		
		Localization local = new Localization();
		String lang =  local.getLocale();
		assertEquals("fr", lang);
	}
	
	@Test
	public void testResourceRU()
	{
		String lang = "ru";

		Resources res = new Resources();
		ResourceBundle rb = res.getBundels(lang);
		String result1 = rb.getString("part1");
		String result2 = rb.getString("part2");
		String result3 = rb.getString("part3");
		String result4 = rb.getString("part4");
		
		assertEquals("Доброе утро, Мир!", result1);
		assertEquals("Добрый день, Мир!", result2);
		assertEquals("Добрый вечер, Мир!", result3);
		assertEquals("Доброй ночи, Мир!", result4);
	}
	
	@Test
	public void testResourceDEF()
	{
		String lang = "en";
		
		Resources res = new Resources();
		ResourceBundle rb = res.getBundels(lang);
		String result1 = rb.getString("part1");
		String result2 = rb.getString("part2");
		String result3 = rb.getString("part3");
		String result4 = rb.getString("part4");
		
		assertEquals("Good morning, World!", result1);
		assertEquals("Good day, World!", result2);
		assertEquals("Good evening, World!", result3);
		assertEquals("Good night, World!", result4);
	}

	@Test
	public void testKey()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date testDate = new Date();
		
		try 
		{
			testDate = sdf.parse("07:00:00");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		Keys keys = new Keys();
		String key = keys.getKey(testDate);
		assertEquals("part1", key);
	}
}
