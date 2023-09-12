
public class Cart {

	int cartID;
	Item [] itemList;
	double cartTotal;
	int numItems;
	
	public Cart()
	{
		itemList = new Item[10];
		numItems = 0;
	}
	
	public void emptyCart()
	{
		itemList = new Item[10];
	}
	
	public void setCartID(int cartIdIn)
	{
		cartID = cartIdIn;
	}
	
	public int getCartID()
	{
		return cartID;
	}
	
	public Item[] getItemList()
	{
		return itemList;
	}

	public void addItem (Item itemAdded)
	{
		itemList[numItems] = itemAdded;
		
		System.out.println("Added Item #" + itemList[numItems].itemNum + " " + itemList[numItems].name + " to Cart " + getCartID() + "\n");
		
		numItems++;
	}
	
	public void removeItem (int itemRemoved)
	{
		for (int i = itemRemoved; i <= numItems; i++)
		{
			if (itemList[i + 1] != null)
			{
				itemList[i] = itemList[i + 1];
			}
		}
		
	}
	
	public void printCartList()
	{
		System.out.println("Cart Contents: \n");
		
		if (itemList[0] == null)
		{
			System.out.println("cart empty \n");
		}
		else
		{
			for (int i = 0; i < numItems; i++)
			{
				System.out.println("Item " + itemList[i].itemNum + ": " + itemList[i].name + ", 1 @ $" + itemList[i].price + "\n");
			}
			
			for (int j = 0; j < numItems; j++)
			{
				cartTotal = (cartTotal + itemList[j].getPrice());  
			}
			
			System.out.println("total in cart: $" + cartTotal + "\n");
		}
	}
	
	public double getTotal()
	{
		if (cartTotal > 0)
		{
			return cartTotal;
		}
		else
		{
			for (int i = 0; i < numItems; i++)
			{
				cartTotal = (cartTotal + itemList[i].getPrice());  
			}
			return cartTotal;
		}
	}

}
