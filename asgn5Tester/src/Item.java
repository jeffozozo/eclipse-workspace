

public class Item {
	
	String name;
	double price;
	int itemNum;
	String description;
	
	public Item(int itemNumIn, String nameIn,  String descriptionIn, double priceIn)
	{
		itemNum = itemNumIn;
		name = nameIn;
		description = descriptionIn;
		price = priceIn;
	}

	public double getPrice()
	{
		return price;
	}

	public void printItem()
	{
		System.out.println("Item: " + itemNum);
		System.out.println("Name: " + name);
		System.out.println("Description: " + description);
		System.out.println("Price: $" + price + "\n");
			
	}
	
}
