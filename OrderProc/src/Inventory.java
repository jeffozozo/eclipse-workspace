
public class Inventory
{
	public int numItems = 25;
	private int[] itemCounts;
	
	public Inventory()
	{
		for(int i=0; i<numItems;i++)
		{
			itemCounts[i] = (int)(Math.random()*40) + 10; 
		}
	}
	
	public synchronized void removeItems(int itemNumIn, int amtIn)
	{
		itemCounts[itemNumIn] -= amtIn;
	}
	
	public void printTotalCount()
	{
		int total = 0;
		for(int i: itemCounts)
		{
			total += i;
		}
		
		System.out.println("total items: " + total);
	}
	
	
	
}
