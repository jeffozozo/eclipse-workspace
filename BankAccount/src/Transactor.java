import java.util.concurrent.locks.ReentrantLock;


public class Transactor implements Runnable
{

	private Bank theBank;
	
	public Transactor(Bank theBankIn)
	{
		theBank = theBankIn;
	}
	
	@Override
	public void run()
	{
		Account to, from;
		double balance;
		double txn;
		ReentrantLock AccountLock = new ReentrantLock();
		
		while(true)
		{
			
				//get two random accounts
				to = theBank.getAccount((int)(Math.random()*theBank.getNumAccounts()));
				from = theBank.getAccount((int)(Math.random()*theBank.getNumAccounts()));	
			
				//make a random txn amount between 10 and 110
				txn = (Math.random()*1000)+100;

				theBank.transfer(to, from, txn);
		

				
			System.out.println(Thread.currentThread() +" amount: "+txn+ " to: "+to.getAccountNum() + " from: " 
			+ from.getAccountNum()+ " total balance: "+ theBank.totalBalance());
			
		}
		
	}

}
