import java.util.*;

public class Cart 
{
	private int cartID = 123;
	protected ArrayList<Item> myList = new ArrayList<Item>();
	
	public Cart ()	
	{
	}
	
	public void cartDisplay()	//display the items within the cart
	{
		for (int i = 0; i < myList.size(); i++)
		{
			System.out.println("Items currently in cart: ");
			myList.get(i).itemDisplay();
		}
	}
	
	public void addItem(int i)
	{
		myList.add(ItemCatalog.itemList.get(i));
	}
	
	public void removeItem(int i)
	{
		myList.remove(ItemCatalog.itemList.get(i));
	}
	
	public void createOrder()
	{
		double orderTotal = 0.0;
		double shipping = 0.0;
		for (int i = 0; i < myList.size(); i++)
		{
			orderTotal += this.myList.get(i).price;
		}
		
		shipping = (myList.size() * 2.99);
		
		Order thisOrder = new Order();
		thisOrder.processOrder(orderTotal, shipping);
	}

}