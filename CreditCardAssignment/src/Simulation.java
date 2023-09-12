
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Simulation implements ActionListener
{
	//queues
	private LinkedBlockingQueue<Transaction> inputQueue = new LinkedBlockingQueue<Transaction>();
	private LinkedBlockingQueue<Transaction> outputQueue = new LinkedBlockingQueue<Transaction>();
	
	private Logger theLog;

	//stuff
	private int nextTxnID = 0;
	private int fillRate = 1000; //milliseconds
	private int startThreads;	
	private DashBoardData data = new DashBoardData();
	private DashBoardFrame theFrame;
	private Timer dbUpdater;
	private Timer filler;
	
	//banks
	private Bank chase = new Bank("Chase");
	private Bank wellsFargo = new Bank("Wells Fargo");
	private Bank citi = new Bank("Citibank");
	private Bank bankOfAmerica = new Bank("Bank of America");
	
	//threadManager
	private ThreadManager threadManager; 

	public Simulation(DashBoardFrame theFrameIn)
	{
		
		//set the frame
		theFrame = theFrameIn;
		startThreads = DashBoardFrame.startThreads;
		
		//set the logger
		theLog = new Logger("transaction.log");
		
		//set up the queues	
		threadManager = new ThreadManager(theLog);
		threadManager.setBanks(chase,wellsFargo,citi,bankOfAmerica);
		threadManager.setQueues(inputQueue,outputQueue);		
		
		theFrame.setThreadManager(threadManager);
		theFrame.setQueueFiller(new QueueFiller());
		
	}
	
	public void start()
	{
		
		//set up the default dashboard data
		data.numThreads = startThreads;
		data.StartTime = new Date();
						
		//start the timer for the inputQueue
		filler = new Timer(fillRate,new QueueFiller());
		filler.start();
		
		//start the timer for the dash board updater
		dbUpdater = new Timer(1000,this);
		dbUpdater.start();

		threadManager.setNumThreads(startThreads);
				
		//main simulation loop - pick things out of the outputQueue and update the info.
		while(true)
		{
			Transaction t = outputQueue.poll();
			if( t != null)
			{
				data.txnsProcessed++;
				updateDashboard();
				setBankTime(t);
				theLog.writeLog("transaction " + t + " completed.");
			}	
		}
	}
	
	
	public void updateDashboard()
	{
		data.pendingRequests = inputQueue.size();
		data.numThreads = threadManager.getNumThreads();
	}
	
	private void setBankTime(Transaction t)
	{
		
		switch(t.bankName)
		{
			case "Citibank":
			{	
				data.CitiTotalTime += t.bankSeconds;
				data.CitiNumTxns++;
				data.CitiAvgTime =  data.CitiTotalTime / data.CitiNumTxns;
				break;
			}
			case "Wells Fargo":
			{
				data.WellsFargoTotalTime += t.bankSeconds;
				data.WellsFargoNumTxns++;
				data.WellsFargoAvgTime = data.WellsFargoTotalTime / data.WellsFargoNumTxns;
				break;
			}
			case "Bank of America":
			{
				data.BofATotalTime += t.bankSeconds;
				data.BofANumTxns++;
				data.BofAAvgTime = data.BofATotalTime/data.BofANumTxns;
				break;
			}
			case "Chase":
			{
				data.ChaseTotalTime += t.bankSeconds;
				data.ChaseNumTxns++;	
				data.ChaseAvgTime = data.ChaseTotalTime / data.ChaseNumTxns;
				break;
			}	
			default :
				theLog.writeLog("Error getting the bank time, the bank name was not correct: " + t.bankName);
				
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		updateDashboard();
		theFrame.updateData(data);
	}
	
	public class QueueFiller implements ActionListener,ChangeListener
	{	
		String[] bankNames = {"Citibank", "Wells Fargo","Bank of America","Chase"};
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Transaction t = new Transaction(nextTxnID++);
			t.acctNum = Integer.toString((int)(Math.random()*10000));
			t.amount = Math.random()*5000;
			t.bankName = bankNames[(int)(Math.random()*4)];
			t.createTime = new Date();
			
			theLog.writeLog("new transaction created: "+ t );
			
			try
			{
				theLog.writeLog("trying to add txn "+t.txnID+" to request queue");
				inputQueue.put(t);
				theLog.writeLog("success adding txn "+t.txnID+" to request queue");
				
			} catch (InterruptedException e1)
			{
				theLog.writeLog("exception "+e1.getMessage()+" when adding txn "+t.txnID+" to the queue.");
			}
		}

		@Override
		public void stateChanged(ChangeEvent e)
		{
			Component component = (Component)e.getSource();
			JSlider addRate = (JSlider)component;
			int numTxnsToAdd = addRate.getValue();
			
			//transactions to add per second. must be > 1
			filler.setDelay(1000/numTxnsToAdd);	
		}
	}//end class QueueFiller


	
}
