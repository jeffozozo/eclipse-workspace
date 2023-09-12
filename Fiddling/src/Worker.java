
public class Worker implements Runnable
{

	@Override
	public void run()
	{
		while(true)
		{
			System.out.println("Hog the CPU");
			
			try
			{
				Thread.sleep(0);
			} catch (InterruptedException e)
			{
				return;
			}
			
		}

	}

}
