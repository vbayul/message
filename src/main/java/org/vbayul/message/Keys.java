package org.vbayul.message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Keys {

	public String getKey(Date currentTime)
	{
        if (betweenStartAndEnd(currentTime, 6, 9))
        	return "part1";
        
        if (betweenStartAndEnd(currentTime, 9, 19))
        	return "part2";
        
        if (betweenStartAndEnd(currentTime, 19, 23))
        	return "part3";

		return "part4";
	}
	
	private boolean betweenStartAndEnd(Date currentTime, int startTime, int endTime)
	{
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
				e.printStackTrace();
		}
 
		if ((timeStart.getTime() <= currentTime.getTime()) 
				&& (timeEnd.getTime() >=currentTime.getTime()))
			return true;
		else
			return false;
	}
}
