package org.vbayul.message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.junit.Test;
import junit.framework.TestCase;

public class MessageTest extends TestCase {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	Date testDate1 = new Date();
	Date testDate2 = new Date();
	Date testDate3 = new Date();
	Date testDate4 = new Date();
	
	@Test
	public void testResourceRU()
	{
		Resources res = new Resources();
		ResourceBundle rb = res.getBundels("ru");
		
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
	public void testResourceDefaultEN()
	{
		Resources res = new Resources();
		ResourceBundle rb = res.getBundels("en");
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
	public void testKeys()
	{
		try 
		{
			testDate1 = sdf.parse("07:00:00");
			testDate2 = sdf.parse("12:00:00");
			testDate3 = sdf.parse("21:30:00");
			testDate4 = sdf.parse("05:00:00");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		Keys keys = new Keys();
		
		String key1 = keys.getKey(testDate1);
		String key2 = keys.getKey(testDate2);
		String key3 = keys.getKey(testDate3);
		String key4 = keys.getKey(testDate4);
		
		assertEquals("part1", key1);
		assertEquals("part2", key2);
		assertEquals("part3", key3);
		assertEquals("part4", key4);
	}
	
	@Test
	public void testParts()
	{
		try 
		{
			testDate1 = sdf.parse("07:00:00");
			testDate2 = sdf.parse("12:00:00");
			testDate3 = sdf.parse("21:30:00");
			testDate4 = sdf.parse("05:00:00");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		Keys keys = new Keys();
		
		String key1 = keys.getKey(testDate1);
		String key2 = keys.getKey(testDate2);
		String key3 = keys.getKey(testDate3);
		String key4 = keys.getKey(testDate4);
		
		Resources rosources = new Resources();
		ResourceBundle bundels = rosources.getBundels("en");
		
		assertEquals("Good morning, World!", bundels.getString(key1));
		assertEquals("Good day, World!", bundels.getString(key2));
		assertEquals("Good evening, World!", bundels.getString(key3));
		assertEquals("Good night, World!", bundels.getString(key4));
	}
	
	@Test
	public void testPart1BorderSixToNineteen()
	{
		try 
		{
			testDate1 = sdf.parse("06:00:00");
			testDate2 = sdf.parse("08:59:59");
			testDate3 = sdf.parse("09:00:00");
			testDate4 = sdf.parse("18:59:59");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		Keys keys = new Keys();
		
		String key1 = keys.getKey(testDate1);
		String key2 = keys.getKey(testDate2);
		String key3 = keys.getKey(testDate3);
		String key4 = keys.getKey(testDate4);
		
		Resources rosources = new Resources();
		ResourceBundle bundels = rosources.getBundels("en");
		
		assertEquals("Good morning, World!", bundels.getString(key1));
		assertEquals("Good morning, World!", bundels.getString(key2));
		assertEquals("Good day, World!", bundels.getString(key3));
		assertEquals("Good day, World!", bundels.getString(key4));
	}
	
	@Test
	public void testPartBordersNineteenToSix()
	{
		try 
		{
			testDate1 = sdf.parse("19:00:00");
			testDate2 = sdf.parse("22:59:59");
			testDate3 = sdf.parse("23:00:00");
			testDate4 = sdf.parse("05:59:59");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		Keys keys = new Keys();
		
		String key1 = keys.getKey(testDate1);
		String key2 = keys.getKey(testDate2);
		String key3 = keys.getKey(testDate3);
		String key4 = keys.getKey(testDate4);
		
		Resources rosources = new Resources();
		ResourceBundle bundels = rosources.getBundels("en");
		
		assertEquals("Good evening, World!", bundels.getString(key1));
		assertEquals("Good evening, World!", bundels.getString(key2));
		assertEquals("Good night, World!", bundels.getString(key3));
		assertEquals("Good night, World!", bundels.getString(key4));
	}
}
