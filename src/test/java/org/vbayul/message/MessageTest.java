package org.vbayul.message;

import java.time.LocalTime;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import junit.framework.TestCase;

public class MessageTest extends TestCase {
	private static final Logger log = LogManager.getLogger(MessageTest.class);

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
		
		LocalTime testTime1 = LocalTime.of(07,0,0);
		LocalTime testTime2 = LocalTime.of(12,00,00);
		LocalTime testTime3 = LocalTime.of(21,30,00);
		LocalTime testTime4 = LocalTime.of(05,00,00);

		
		log.debug("Prepare method keys");		
		Keys keys = new Keys();
		
		String key1 = keys.getKey(testTime1);
		String key2 = keys.getKey(testTime2);
		String key3 = keys.getKey(testTime3);
		String key4 = keys.getKey(testTime4);
		
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
		
		LocalTime testTime1 =  LocalTime.of(7,00,00);
		LocalTime testTime2 =  LocalTime.of(12,00,00);
		LocalTime testTime3 =  LocalTime.of(21,30,00);
		LocalTime testTime4 =  LocalTime.of(5,00,00);

		
		log.debug("Prepare method keys");
		Keys keys = new Keys();
		
		String key1 = keys.getKey(testTime1);
		String key2 = keys.getKey(testTime2);
		String key3 = keys.getKey(testTime3);
		String key4 = keys.getKey(testTime4);
		
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
		LocalTime testTime1 =  LocalTime.of(6,00,00);
		LocalTime testTime2 =  LocalTime.of(8,59,59);
		LocalTime testTime3 =  LocalTime.of(9,00,00);
		LocalTime testTime4 =  LocalTime.of(18,59,59);

		log.debug("Prepare method keys");
		Keys keys = new Keys();
		
		String key1 = keys.getKey(testTime1);
		String key2 = keys.getKey(testTime2);
		String key3 = keys.getKey(testTime3);
		String key4 = keys.getKey(testTime4);
		
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

		LocalTime testTime1 =  LocalTime.of(19,00,00);
		LocalTime testTime2 =  LocalTime.of(22,59,59);
		LocalTime testTime3 =  LocalTime.of(23,00,00);
		LocalTime testTime4 =  LocalTime.of(05,59,59);
			
		log.debug("Prepare method keys");
		Keys keys = new Keys();
		
		String key1 = keys.getKey(testTime1);
		String key2 = keys.getKey(testTime2);
		String key3 = keys.getKey(testTime3);
		String key4 = keys.getKey(testTime4);
		
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
