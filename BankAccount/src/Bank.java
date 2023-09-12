import java.util.ArrayList;


public class Bank
{
	private int numAccounts = 3;
	private Account[] accounts;
	
	int count = 0;
	

	public Bank()
	{
		accounts = new Account[numAccounts];
		//generate some random accounts
		for(int i=0;i<numAccounts;i++)
		{
			accounts[count] = new Account(i,5000);
			count++;
		}
	}
	
	public Account getAccount(int accountNum)
	{
		return accounts[accountNum];
	}

	public int getNumAccounts()
	{
		return numAccounts;
	}

	synchronized public void  transfer(Account to, Account from, double amt)
	{
		from.debit(amt);
		to.credit(amt);
	}
	
	public double totalBalance()
	{
		double totalBalance = 0;
		
		for(Account a: accounts)
		{
			totalBalance += a.getBalance();
		}
				
		return totalBalance;
	}
	
	
	
}
