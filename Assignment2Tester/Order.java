import java.util.*;
import java.text.*;

public class Order extends Cart
{
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
       //get current date time with Date()
   private Date orderDate = new Date();
	private String paymentType = "PayPal";
	private int orderNumber = 1;
	private double orderTotal = 0.0;
	
	private ArrayList<Item> myOrder = new ArrayList<Item>(this.myList); //copy the cart list to the order's list

	
	DecimalFormat f = new DecimalFormat("##.00"); //for formatting the dollar amounts

	
	public void processOrder(double ot, double shipping) 
	{
		System.out.println("Order Number " + this.orderNumber + " for Account 1");
		System.out.println("Payment Type: " + this.paymentType + "\nOrderDate: " + df.format(this.orderDate));
		System.out.println("Order Amount: $" + f.format(ot));
		System.out.println("Shipping: $" + f.format(shipping));
		System.out.println("Order Total + Shipping: $" + f.format(ot + shipping));
	
		
	}
	
}