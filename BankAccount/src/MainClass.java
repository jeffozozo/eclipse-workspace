import java.util.concurrent.BlockingQueue;


public class MainClass
{

	public static void main(String[] args)
	{
		BlockingQueue inputQueue = new BlockingQueue();
		
		Thread t1 = new Thread(new WorkerThread(theInputQueue, theOutput));
		Thread t2 = new Thread(new Transactor(theBank));
		Thread t3 = new Thread(new Transactor(theBank));
		
		Thread t4 = new Thread(new Transactor(theBank));
		Thread t5 = new Thread(new Transactor(theBank));
		Thread t6 = new Thread(new Transactor(theBank));
		
		
		System.out.println("At the start, the Bank's total balance is: " + theBank.totalBalance());
		
		t1.start();
		t2.start();
		t3.start();
		
		t4.start();
		t5.start();
		t6.start();
		
		
		while(true)
		{
			System.out.println("The Bank total: "+ theBank.totalBalance());
		}

	}

}
