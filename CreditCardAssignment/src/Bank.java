
public class Bank
{
	private int minTime;
	private int maxTime;
	private String name;
	
	public Bank(String nameIn)
	{
		name = nameIn;
		
		minTime = (int)(Math.random()*7) + 1;
		maxTime = (int)(Math.random()*1) + 7;
	}
	
	public String getName()
	{
		return name;
	}
	
	
	public void Authorize(Transaction t) throws InterruptedException
	{
		//sleep time in seconds
		int sleepTime = 1000 * (minTime + (int)(Math.random()*maxTime));
		
		try
		{
			Thread.sleep(sleepTime);
		}
		catch(InterruptedException e)
		{
			t.approved = false;
			throw(e);
		}
		
		//randomly approve things. roughly 80% of txns will be approved.
		t.approved = (Math.random()*10 < 8);
		
	}
	
}
