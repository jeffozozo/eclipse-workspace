
public class MainClass 
{
	public static void main(String[] args)
	{
		
		System.out.println("Internet store Jeffs Jams and Jellies open and online...");
		
		Account theAccount = new Account("jeffozozo","ok123");
		ItemCatalog theCatalog = new ItemCatalog();
		
		theCatalog.addItem(new Item("105","Strawberry Jam","Delicious, rich, just like mom used to make",3.91));
		theCatalog.addItem(new Item("205","Elderberry Jam","Dark and tart, this jam packs a punch!",4.87));
		theCatalog.addItem(new Item("305","Raspberry Jelly","Fresh and sweet, seeds in.",3.95));
		
		System.out.println();
		theCatalog.printCatalog();

		theAccount.OrderItem(theCatalog.getItem(0));
		theAccount.OrderItem(theCatalog.getItem(2));
		theAccount.OrderItem(theCatalog.getItem(2));
		
		theAccount.checkOut(1);
		
		theAccount.OrderItem(theCatalog.getItem(1));
		theAccount.OrderItem(theCatalog.getItem(2));
		
		theAccount.checkOut(2);
		
		theAccount.printOrders();
				
		
	}

}
