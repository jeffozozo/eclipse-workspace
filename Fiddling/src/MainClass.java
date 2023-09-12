
public class MainClass
{

	public static void main(String[] args)
	{
		Worker w = new Worker();
		
		Thread t = new Thread(w);
		t.start();

	while(t.isAlive())
	{
		
		try
		{
			Thread.sleep(5000);
			
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.interrupt();
	}	
		
	System.out.println("Main Thread Exiting.");

	}

}
