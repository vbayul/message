package org.vbayul.message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.junit.Test;
import junit.framework.TestCase;

public class MessageTest extends TestCase {
	
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
	
	@Test
	public void testPart1()
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
		Resources rosources = new Resources();
		ResourceBundle bundels = rosources.getBundels("en");
		
		assertEquals("Good morning, World!", bundels.getString(key));
	}
	
	@Test
	public void testPart2()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date testDate = new Date();
		
		try 
		{
			testDate = sdf.parse("12:00:00");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		Keys keys = new Keys();
		String key = keys.getKey(testDate);
		Resources rosources = new Resources();
		ResourceBundle bundels = rosources.getBundels("en");
		
		assertEquals("Good day, World!", bundels.getString(key));
	}
	
	@Test
	public void testPart3()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date testDate = new Date();
		
		try 
		{
			testDate = sdf.parse("21:30:00");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		Keys keys = new Keys();
		String key = keys.getKey(testDate);
		Resources rosources = new Resources();
		ResourceBundle bundels = rosources.getBundels("en");
		
		assertEquals("Good evening, World!", bundels.getString(key));
	}
	
	@Test
	public void testPart4()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date testDate = new Date();
		
		try 
		{
			testDate = sdf.parse("05:00:00");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		Keys keys = new Keys();
		String key = keys.getKey(testDate);
		Resources rosources = new Resources();
		ResourceBundle bundels = rosources.getBundels("en");
		
		assertEquals("Good night, World!", bundels.getString(key));
	}
	
	@Test
	public void testPart1Border()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date testDate = new Date();
		
		try 
		{
			testDate = sdf.parse("06:00:00");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		Keys keys = new Keys();
		String key = keys.getKey(testDate);
		Resources rosources = new Resources();
		ResourceBundle bundels = rosources.getBundels("en");
		
		assertEquals("Good morning, World!", bundels.getString(key));
		try 
		{
			testDate = sdf.parse("08:59:59");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}

		key = keys.getKey(testDate);
		rosources = new Resources();
		bundels = rosources.getBundels("en");
		
		assertEquals("Good morning, World!", bundels.getString(key));
	}
	
	@Test
	public void testPart2Border()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date testDate = new Date();
		
		try 
		{
			testDate = sdf.parse("09:00:00");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		Keys keys = new Keys();
		String key = keys.getKey(testDate);
		Resources rosources = new Resources();
		ResourceBundle bundels = rosources.getBundels("en");
		
		assertEquals("Good day, World!", bundels.getString(key));
		try 
		{
			testDate = sdf.parse("18:59:59");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}

		key = keys.getKey(testDate);
		rosources = new Resources();
		bundels = rosources.getBundels("en");
		
		assertEquals("Good day, World!", bundels.getString(key));
	}
	
	@Test
	public void testPart3Border()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date testDate = new Date();
		
		try 
		{
			testDate = sdf.parse("19:00:00");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		Keys keys = new Keys();
		String key = keys.getKey(testDate);
		Resources rosources = new Resources();
		ResourceBundle bundels = rosources.getBundels("en");
		
		assertEquals("Good evening, World!", bundels.getString(key));
		try 
		{
			testDate = sdf.parse("22:59:59");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}

		key = keys.getKey(testDate);
		rosources = new Resources();
		bundels = rosources.getBundels("en");
		
		assertEquals("Good evening, World!", bundels.getString(key));
	}
	
	@Test
	public void testPart4Border()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date testDate = new Date();
		
		try 
		{
			testDate = sdf.parse("23:00:00");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		Keys keys = new Keys();
		String key = keys.getKey(testDate);
		Resources rosources = new Resources();
		ResourceBundle bundels = rosources.getBundels("en");
		
		assertEquals("Good night, World!", bundels.getString(key));
		try 
		{
			testDate = sdf.parse("05:59:59");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}

		key = keys.getKey(testDate);
		rosources = new Resources();
		bundels = rosources.getBundels("en");
		
		assertEquals("Good night, World!", bundels.getString(key));
	}
}
