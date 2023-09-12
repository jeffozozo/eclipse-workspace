
public class Account 
{
	String username;
	String password;
	int id;
	Cart theCart;
	Order[] orderList;
	int currentOrder;
	
	
	public void OrderItem(Item itemToPutInTheCart)
	{
		theCart.addItem(itemToPutInTheCart);
	}
	
	public Account(String usernameIn, String passwordIn)
	{
		username = usernameIn;
		password = passwordIn;
		id = 5;	
		
		System.out.println("New account created for "+username+" account ID:"+ id);
		
		orderList = new Order[10];
		currentOrder=0;
		
		theCart = new Cart();
		System.out.println("Cart ID " + theCart.getID() + " created and attached to account ID " + id);
	}
	
	public void checkOut(int orderNum)
	{
		Order temp = new Order(theCart);
		System.out.println("Order Created.");
		temp.setOrderNum(orderNum);
		
		orderList[currentOrder] = temp;
		currentOrder++;
		
		temp.printOrderInfo();
		
		theCart = new Cart(); //clear the cart.
		
	}
	
	public void printOrders()
	{
		for(int i=0;i<currentOrder;i++)
		{
			orderList[i].printOrder();		
		}	
	}

}
