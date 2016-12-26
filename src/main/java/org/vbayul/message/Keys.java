package org.vbayul.message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Keys {
	private static final Logger log = LogManager.getLogger("file");
	
	public String getKey(Date currentTime)
	{
		log.info("Starting getKeys method");
        if (betweenStartAndEnd(currentTime, 6, 9))
        {
        	log.info("Ending getKeys method");
            return "part1";
        }
        if (betweenStartAndEnd(currentTime, 9, 19))
        {
        	log.info("Ending getKeys method");
        	return "part2";
        }
        if (betweenStartAndEnd(currentTime, 19, 23))
        {
        	log.info("Ending getKeys method");
            return "part3";
    	}
		log.info("Ending getKeys method");
		return "part4";
	}
	
	private boolean betweenStartAndEnd(Date currentTime, int startTime, int endTime)
	{
		log.info("Starting betweenStartAndEnd method with " + startTime +" - "+ endTime);
		Date timeStart = null;
		Date timeEnd = null;
		
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
        try
		{
			timeStart = sdf.parse(startTime+":00:00");
			currentTime = sdf.parse(sdf.format(currentTime)); 
			timeEnd = sdf.parse((endTime-1)+":59:59");
		}
		catch (ParseException e) 
		{
				log.info(e.getMessage());
		}
 
		if ((timeStart.getTime() <= currentTime.getTime()) 
				&& (timeEnd.getTime() >=currentTime.getTime()))
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
