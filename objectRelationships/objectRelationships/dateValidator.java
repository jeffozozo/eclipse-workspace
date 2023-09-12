package objectRelationships;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateValidator 
{
	//expects date in the format mm/dd/yy
	public static boolean validateDate(String date_in)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		Date test = null;
		
		try
		{
			test = sdf.parse(date_in);
		}
		catch(Exception e)
		{
			return false;
		}
		
		if(sdf.format(test).equals(date_in))
			return true;
		
		return false;
	}
}
