import java.text.*;

public class Item
{
	public String name;
	public double price;
	public int itemNum;
	public String description;
	
	DecimalFormat f = new DecimalFormat("##.00"); //for formatting the dollar amounts
	
	public Item (String nameIn, double priceIn, int itemNumIn, String descriptionIn)	
	{
		this.name = nameIn;
		this.price = priceIn;
		this.itemNum = itemNumIn;
		this.description = descriptionIn;
	}
	
	public Item () {}
	
	public void itemDisplay()
	{
		System.out.printf("\n\nItem Number: " + this.itemNum + "\nName: " + this.name + 
			"\nDescription: " + this.description + "\nPrice: $" + f.format(this.price));
	}
}