
public class Account
{
	private double balance;
	private int accountNum;
	
	public Account(int accountNumIn, double startingBalance)
	{
		accountNum = accountNumIn;
		balance = startingBalance;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	public int getAccountNum()
	{
		return accountNum;
	}
	
	public void debit(double amt)
	{
		balance -= amt;
	}
	
	public void credit(double amt)
	{
		balance += amt;
	}
	


}
