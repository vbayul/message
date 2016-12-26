package org.vbayul.message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import junit.framework.TestCase;

public class MessageTest extends TestCase {
	private static final Logger log = LogManager.getLogger(MessageTest.class);

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	Date testDate1 = new Date();
	Date testDate2 = new Date();
	Date testDate3 = new Date();
	Date testDate4 = new Date();
	
	@Test
	public void testResourceRU()
	{

		log.debug("Begin test of resources of Russian languche");
		log.debug("Prepare resources");
		
		Resources res = new Resources();
		ResourceBundle rb = res.getBundels("ru");
		
		String result1 = rb.getString("part1");
		String result2 = rb.getString("part2");
		String result3 = rb.getString("part3");
		String result4 = rb.getString("part4");
		
		log.debug("Сompare results");
		
		assertEquals("Доброе утро, Мир!", result1);
		assertEquals("Добрый день, Мир!", result2);
		assertEquals("Добрый вечер, Мир!", result3);
		assertEquals("Доброй ночи, Мир!", result4);
		log.debug("Test of resources of Russian languche successful\n");
	}
	
	@Test
	public void testResourceDefaultEN()
	{
		log.debug("Begin test of resources of English/Default languche");	
		
		log.debug("Prepare resources");
		Resources res = new Resources();
		ResourceBundle rb = res.getBundels("en");
		
		String result1 = rb.getString("part1");
		String result2 = rb.getString("part2");
		String result3 = rb.getString("part3");
		String result4 = rb.getString("part4");
		
		log.debug("Сompare results");
		
		assertEquals("Good morning, World!", result1);
		assertEquals("Good day, World!", result2);
		assertEquals("Good evening, World!", result3);
		assertEquals("Good night, World!", result4);
		log.debug("Test of resources of English/Default languche successful\n");
	}

	@Test
	public void testKeys()
	{
		log.debug("Test of Keys method begin");
		log.debug("Prepare variables");
		
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
		
		log.debug("Prepare method keys");		
		Keys keys = new Keys();
		
		String key1 = keys.getKey(testDate1);
		String key2 = keys.getKey(testDate2);
		String key3 = keys.getKey(testDate3);
		String key4 = keys.getKey(testDate4);
		
		log.debug("Сompare results");
		
		assertEquals("part1", key1);
		assertEquals("part2", key2);
		assertEquals("part3", key3);
		assertEquals("part4", key4);
		
		log.debug("Test of Keys method successful\n");
	}
	
	@Test
	public void testParts()
	{
		log.debug("Test of  begin");
		log.debug("Prepare variables");
		
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
		
		log.debug("Prepare method keys");
		Keys keys = new Keys();
		
		String key1 = keys.getKey(testDate1);
		String key2 = keys.getKey(testDate2);
		String key3 = keys.getKey(testDate3);
		String key4 = keys.getKey(testDate4);
		
		log.debug("Prepare resource");
		Resources rosources = new Resources();
		ResourceBundle bundels = rosources.getBundels("en");
		log.debug("Сompare results");
		assertEquals("Good morning, World!", bundels.getString(key1));
		assertEquals("Good day, World!", bundels.getString(key2));
		assertEquals("Good evening, World!", bundels.getString(key3));
		assertEquals("Good night, World!", bundels.getString(key4));
		log.debug("Test of random parts is successful\n");
	}
	
	@Test
	public void testPart1BorderSixToNineteen()
	{
		log.debug("Test of border between  6-9 and 9-19 begin");
		log.debug("Prepare variables");
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
		log.debug("Prepare method keys");
		Keys keys = new Keys();
		
		String key1 = keys.getKey(testDate1);
		String key2 = keys.getKey(testDate2);
		String key3 = keys.getKey(testDate3);
		String key4 = keys.getKey(testDate4);
		
		log.debug("Prepare resource");
		Resources rosources = new Resources();
		ResourceBundle bundels = rosources.getBundels("en");
		
		log.debug("Сompare results");
		assertEquals("Good morning, World!", bundels.getString(key1));
		assertEquals("Good morning, World!", bundels.getString(key2));
		assertEquals("Good day, World!", bundels.getString(key3));
		assertEquals("Good day, World!", bundels.getString(key4));
		log.debug("Test of border between  6-9 and 9-19 successful\n");
	}
	
	@Test
	public void testPartBordersNineteenToSix()
	{
		log.debug("Test of border between  19-23 and 23-6 begin");
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
		log.debug("Prepare method keys");
		Keys keys = new Keys();
		
		String key1 = keys.getKey(testDate1);
		String key2 = keys.getKey(testDate2);
		String key3 = keys.getKey(testDate3);
		String key4 = keys.getKey(testDate4);
		
		log.debug("Prepare resource");
		Resources rosources = new Resources();
		ResourceBundle bundels = rosources.getBundels("en");
		
		log.debug("Сompare results");		
		assertEquals("Good evening, World!", bundels.getString(key1));
		assertEquals("Good evening, World!", bundels.getString(key2));
		assertEquals("Good night, World!", bundels.getString(key3));
		assertEquals("Good night, World!", bundels.getString(key4));
		log.debug("Test of border between  19-23 and 23-6 is successful\n");
	}
}
