import java.util.*;

public class ItemCatalog
{
	
	static ArrayList<Item> itemList = new ArrayList<Item>();
	public ItemCatalog ()	
	{
		//generate the catalog items here (because...well, why not?)		
		itemList.add(new Item("Raspberry Jelly", 4.95, 1, "A full bodied raspberry jelly, complete with seeds."));
		itemList.add(new Item("Strawberry Jam", 3.95, 2, 
 			"Just like mom used to make! Thick and rich, full of fresh flavor!"));
		itemList.add(new Item("Elderberry Jam", 5.10, 3, "Dark and tart; this jam packs a wallop!"));

	}
	
	public void catalogDisplay()	//display the items within the catalog
	{
		for (int i = 0; i < itemList.size(); i++)
		{
			itemList.get(i).itemDisplay();
		}
	}
	
	
	
}