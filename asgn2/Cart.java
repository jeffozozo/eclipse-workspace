import java.text.DecimalFormat;


public class Cart 
{
	int id;
	Item[] itemList;
	int current;
	
	public Cart()
	{
		id = 1;
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
	
	public int getID()
	{
		return id;
	}
	
	public void printItems()
	{
		double total=0;
		DecimalFormat df = new DecimalFormat("##.##");
		
		System.out.println("Printing items in cart: ");
		for(int i=0;i<current;i++)
		{
			itemList[i].printItem();
			total = total + itemList[i].getPrice();
			System.out.println();
		}
		System.out.println("Total in cart: $"+ df.format(total));
		System.out.println("end cart.");
	}
	
}
