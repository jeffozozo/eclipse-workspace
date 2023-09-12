import java.util.concurrent.LinkedBlockingQueue;


public class Worker implements Runnable
{

	Inventory theInventory;
	LinkedBlockingQueue<Order> theQueue;
	
	public Worker(Inventory invIn, LinkedBlockingQueue theQueueIn)
	{
		theInventory = invIn;
		theQueue = theQueueIn;
	}
	
	@Override
	public void run()
	{
		Order o = theQueue.poll();
		
		
	}

}
