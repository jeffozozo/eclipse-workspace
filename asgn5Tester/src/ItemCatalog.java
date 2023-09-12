

public class ItemCatalog {
	
	int numItems;
	Item [] itemList;
	
	public ItemCatalog()
	{
		itemList = new Item[3];	
	}

	public void addItem (Item itemAdded)
	{
		itemList[numItems] = itemAdded;
		numItems++;
	}

	public void printItemList ()
	{
		for (int i = 0; i < numItems; i++)
		{
			itemList[i].printItem();
		}
	}
}
