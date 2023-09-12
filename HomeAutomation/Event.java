import java.sql.Time;


public class Event 
{
	private Time time;
	private String objName;
	private Action action;
	
	public String ToString()
	{
		String temp;
		temp = time +" " + objName + " " + action;
		
		return temp;
	}
}
