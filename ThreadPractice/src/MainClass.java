import java.util.ArrayList;

import javax.swing.SwingWorker;


public class MainClass
{
	public static void main(String[] args) throws InterruptedException
	{
		ArrayList<Thread> workerList = new ArrayList<Thread>();
		for(int i=0;i<10;i++)
		{
			Worker w = new Worker();
			Thread t = new Thread(w);
			
			workerList.add(t);
			
			t.start();
			Thread.sleep(2000);
		}

		
		Thread.sleep(5000);
		
		for(Thread t : workerList)
		{
			t.interrupt();
			t.join(); //wait until t finishes then continue.
		}
		
		System.out.println("I want to finish last.");	

	}

}
