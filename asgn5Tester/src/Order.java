import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
	
	int AccountID;
	Date date;
	int orderNum;
	double orderTotal;
	String paymentMethod;
	int cardNum;
	DateFormat dateFormat;
	
	public Order(String paymentMethodIn, int cardNumIn, int AccountIdIn, double orderTotalIn)
	{
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		date = new Date();
		paymentMethod = paymentMethodIn;
		cardNum = cardNumIn;
		AccountID = AccountIdIn;
		orderNum++;
		orderTotal = orderTotalIn;
		
	}
	
	public void printOrder()
	{
		System.out.println("Payment type: " + paymentMethod + "\n");
		System.out.println("Account Num: " + AccountID + "\n");
		System.out.println("Order date: " + dateFormat.format(date) + "\n");
		System.out.println("Order Amount: $" + orderTotal + "\n");
		if (orderTotal > 0)
		{
			System.out.println("Shipping: $8.50");
		}
		else
		{
			System.out.println("Shipping: $0");
		}
	}

}
