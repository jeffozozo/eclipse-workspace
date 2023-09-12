import java.util.concurrent.LinkedBlockingQueue;


public class MainClass
{

		public static void main(String[] args)
		{
			Inventory inv = new Inventory();
			LinkedBlockingQueue<Order> theQueue = new LinkedBlockingQueue<Order>();
			
			Worker w1 = new Worker(inv,theQueue);
			Worker w2 = new Worker(inv, theQueue);
			Worker w3 = new Worker(inv, theQueue);
			

			
			
			
		}
}
