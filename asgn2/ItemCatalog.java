
public class ItemCatalog 
{
	Item[] itemList;
	int current;
	
	public ItemCatalog()
	{
		itemList = new Item[10];
		current = 0;
	}
	
	public boolean addItem(Item itemIn)
	{
		if(current<10)
		{
			itemList[current] = itemIn;
			current++;
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	public boolean removeItem(int index)
	{
		if(index < current)
		{
			for(int i=index;i<current;i++)
			{
				itemList[i] = itemList[i+1];
				return true;
			}
		}	
		
		return true;
		
	}
	
	public void printCatalog()
	{
		System.out.println("***Printing catalog");
		for(int i=0;i<current;i++)
		{
			itemList[i].printItem();
			System.out.println();
		}
		System.out.println("***end catalog");
		System.out.println();
	}
	
	public Item getItem(int index)
	{
		if(index<current)
			return itemList[index];
		
		return null;
		
	}
	
	
}
