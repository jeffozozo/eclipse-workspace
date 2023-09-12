
public class TimeWaster implements Runnable
{

	int threadID;
	long count;
	
	public TimeWaster(int idIn)
	{
		threadID = idIn;
		count = 1;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(1);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				
			}
			count++;
			System.out.println("Thread ID: "+ threadID+ " has counted to: "+ count);

		}
	}


}
