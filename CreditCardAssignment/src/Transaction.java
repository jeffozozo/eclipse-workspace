import java.text.DecimalFormat;
import java.util.Date;


public class Transaction
{
	int txnID;
	String bankName;
	String acctNum;
	double amount;
	boolean approved;
	
	Date createTime;
	int bankSeconds;
	Date completeTime;
		
	public Transaction(int txnIDin)
	{
		txnID = txnIDin;
	}
	
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("#0.00");
				
		return new String("ID: "+ txnID+ " Bank: "+bankName+" acct:"+acctNum+" amt:"+df.format(amount));
	}
	
	public void setBankSeconds(Date bankStart, Date bankEnd)
	{
		bankSeconds = (int)(bankEnd.getTime()-bankStart.getTime())/1000;
	}
	
}
