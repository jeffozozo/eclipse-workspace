import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public class WorkerThread implements Runnable
{

	public boolean finished = false;
	private Logger log;
	private long workerID;
	
	Bank Citi;
	Bank WellsFargo;
	Bank Chase;
	Bank BankOfAmerica;
	
	LinkedBlockingQueue<Transaction> inputQueue;
	LinkedBlockingQueue<Transaction> outputQueue;
	
	public WorkerThread(Logger logFileIn)
	{
		log = logFileIn;
	}
	public long getID()
	{
		return workerID;
	}
	
	public void setupBanks(Bank citiIn, Bank wfIn, Bank chaseIn, Bank bofaIn)
	{

		Citi = citiIn;
		WellsFargo = wfIn;
		Chase = chaseIn;
		BankOfAmerica = bofaIn;
	}
	
	public void setupQueues(LinkedBlockingQueue<Transaction> inputQueueIn, LinkedBlockingQueue<Transaction> outputQueueIn)
	{
		inputQueue = inputQueueIn;
		outputQueue = outputQueueIn;
	}
	
	@Override
	public void run()
	{
		Transaction request;
		
		//get the threadID
		workerID = Thread.currentThread().getId();
		
		log.writeLog("Starting worker thread: "+workerID );
		
		while(!finished)
		{
			//get a request from the queue
			request = null;
			try
			{
				request = inputQueue.poll(100,TimeUnit.MILLISECONDS);
				
				if(request != null)
				{
					processTxn(request);	
				}
				else
				{
					//wait for half a second before trying to get a new item from the queue
					Thread.sleep(500);
				}				
			} 
			catch (InterruptedException e1)
			{
				finished = true;
			}
			
		}//end while
					
		log.writeLog("worker thread "+workerID+ " finishing.");
		
	}// end run()
	
	
	private void processTxn(Transaction request) throws InterruptedException
	{
		
		Bank contactBank;
		Date bankStart;
		Date bankEnd;
		
		log.writeLog("Worker "+workerID + " Processing Request: " + request);
		
		//get the bank from the request
		contactBank = getBank(request);
		
		//call Bank.Authorize
		log.writeLog("worker: " + workerID + " Authorizing txn: "+request.txnID+" at: " + contactBank.getName());
		bankStart = new Date();
		contactBank.Authorize(request);
		bankEnd = new Date();
		request.setBankSeconds(bankStart,bankEnd);
		
		log.writeLog("Request " +request.txnID+" returned in: "+request.bankSeconds+" seconds. Result: " + request.approved);
				
		//put the updated request into the results queue
		outputQueue.put(request);
		log.writeLog("Request " +request.txnID+" placed in output queue.");
	
	}
	
	private Bank getBank(Transaction t)
	{
		switch(t.bankName)
		{
			case "Citibank" 		: return Citi;
			case "Chase"    		: return Chase;	 
			case "Wells Fargo"		: return WellsFargo;
			case "Bank of America"	: return BankOfAmerica;
				
			default:
				return null;			
		}
		
	}

}
