import java.awt.Component;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class ThreadManager implements ChangeListener
{
	private ArrayList<WorkerThread> workers = new ArrayList<WorkerThread>();
	private Logger theLog;
	
	private Bank chase;
	private Bank wellsFargo;
	private Bank citi;
	private Bank bankOfAmerica;
	
	private LinkedBlockingQueue inputQueue;
	private LinkedBlockingQueue outputQueue;
	
	private int currentNumThreads = 1;
	
	public ThreadManager(Logger theLogIn)
	{
		theLog = theLogIn;
	}
	
	public void setQueues(LinkedBlockingQueue inputQueueIn, LinkedBlockingQueue outputQueueIn)
	{
		inputQueue = inputQueueIn;
		outputQueue = outputQueueIn;
	}
	
	public void setBanks(Bank chaseIn, Bank wfIn, Bank citiIn, Bank bofAIn)
	{
		chase = chaseIn;
		wellsFargo = wfIn;
		citi = citiIn;
		bankOfAmerica = bofAIn;
	}
	
	@Override
	public void stateChanged(ChangeEvent e)
	{

		Component component = (Component)e.getSource();
		String controller = component.getName();
		
		JSpinner numWorkers = (JSpinner)component;
		currentNumThreads = (int) numWorkers.getValue();

		manageThreads();
	
	}
	
	public void setNumThreads(int threadsIn)
	{
		currentNumThreads = threadsIn;
		manageThreads();
	}
	
	public int getNumThreads()
	{
		return currentNumThreads;
	}
	
	private void manageThreads()
	{
		if(currentNumThreads < workers.size())
		{
			while(currentNumThreads < workers.size())
			{
				//stop some threads
				stopThread();
			}
		}
		else
		{
			while(currentNumThreads > workers.size())
			{
				startThread();
			}
		}	
		
		
		
	}
	
	private void stopThread()
	{
		if(workers.size()>0)
		{
			WorkerThread w = workers.get(0);
			w.finished = true;
			workers.remove(0);			
		}
	}
	
	private void startThread()
	{
		WorkerThread worker = new WorkerThread(theLog);
		
		//setupBanks(Bank citiIn, Bank wfIn, Bank chaseIn, Bank bofaIn
		worker.setupBanks(citi,wellsFargo,chase,bankOfAmerica);
		worker.setupQueues(inputQueue, outputQueue);
		
		//add the thread to the list
		
		Thread temp = new Thread(worker);
		workers.add(worker);
		
		temp.start();
		
	}

}
