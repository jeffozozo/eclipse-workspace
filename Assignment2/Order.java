import java.util.Date;


public class Order 
{
	int orderNum;
	Cart aCart;
	Date date;
	
	public Order(Cart cartIn)
	{
		orderNum = 0;
		aCart = cartIn;
		date = new Date();
	}
	
	public void setOrderNum(int numIn)
	{
		orderNum = numIn;
	}
	
	public void printOrder()
	{
		System.out.println();
		System.out.println("Order " + orderNum + " was placed on "+date+" and contained these items:");
		aCart.printItems();
	}
	
	public void printOrderInfo()
	{
		System.out.println("Order " + orderNum + " was placed on "+date);
	}
	
	
	
	
}
