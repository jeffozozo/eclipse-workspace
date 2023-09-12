
public class Worker implements Runnable
{
	
	public boolean finished = false;
	
	public void run()
	{

		while(!finished)
		{
			System.out.println("Hello from thread "+Thread.currentThread().getId());

			int waitTime = ((int)(Math.random()*8)+2)*1000;
			
			try
			{
				Thread.sleep(waitTime);
			}
			catch(InterruptedException e)
			{
				finished = true;
			}
		}
		
		System.out.println("Worker "+Thread.currentThread().getId()+" finished.");
	
	}
}
