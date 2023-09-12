
public class Item 
{
	String itemID;
	String name;
	String description;
	double price;
	
	public Item(String IDin, String nameIn, String descriptionIn, double priceIn)
	{
		itemID = IDin;
		name = nameIn;
		description = descriptionIn;
		price = priceIn;
		
	}
	
	public void printItem()
	{
		System.out.println("ItemID: "+itemID);
		System.out.println("Name: "+name);
		System.out.println("Description: "+description);
		System.out.println("Price: "+price);
	}
	
	public double getPrice()
	{
		return price;
	}
	
	
	
}
