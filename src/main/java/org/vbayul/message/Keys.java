package org.vbayul.message;

import java.time.LocalTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Keys {
	private static final Logger log = LogManager.getLogger("file");
	
	public String getKey(LocalTime currentTime)
	{
		String key = "part4";
		
		log.info("Starting getKeys method");
        if (isBetweenStartAndEnd(currentTime, 6, 9))
        {
        	log.info("Ending getKeys method");
        	key = "part1";
        }
        if (isBetweenStartAndEnd(currentTime, 9, 19))
        {
        	log.info("Ending getKeys method");
        	key = "part2";
        }
        if (isBetweenStartAndEnd(currentTime, 19, 23))
        {
        	log.info("Ending getKeys method");
        	key = "part3";
    	}
        
		log.info("Ending getKeys method");
		return key;
	}
	
	private boolean isBetweenStartAndEnd(LocalTime currentTime, int startTime, int endTime)
	{
		log.info("Starting betweenStartAndEnd method with " + startTime +" - "+ endTime);
		LocalTime timeStart = LocalTime.of(startTime-1, 59, 59);
		LocalTime timeEnd = LocalTime.of(endTime, 00, 00);

		if ((currentTime.isAfter(timeStart)) 
				&& (currentTime.isBefore(timeEnd)))
		{
			log.info("Ending betweenStartAndEnd method");
			return true;
		}
		else
		{
			log.info("End betweenStartAndEnd method");
			return false;
		}
	}
}
