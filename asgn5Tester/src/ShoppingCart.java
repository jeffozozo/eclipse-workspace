
public class ShoppingCart {
	
	public static void main(String[] args) { 
		
		Account a = new Account("Matkinson", "PingPong", 1);
		
		a.getUserCart().setCartID(a.getAccountID()); //set the account ID and the cart ID equal to each other
		
		ItemCatalog IC = new ItemCatalog();
		
		Item item1 = new Item(1, "Avengers", "Marvels superheros come together", 25.00);
		Item item2 = new Item(2, "Inception", "Dream within a Dream", 15.00);
		Item item3 = new Item(3, "Star Trek", "The new adventers of the star ship enterprise", 20.00);
		
		IC.addItem(item1);
		IC.addItem(item2);
		IC.addItem(item3);
		
		System.out.println("***Matthew's Movie Madness... \n");
		System.out.println("\n");
		System.out.println("AccountID " + a.getAccountID() + " - Created");
		System.out.println("Username: "+a.getUserName());
		System.out.println("Password: "+a.getPassword() + "\n");
		System.out.println("\n");
		System.out.println("CartID " + a.getUserCart().getCartID() + " - Created, attached to AccountID " + a.getAccountID() + "\n");
		System.out.println("\n");
		System.out.println("Item Catalog Listing \n");
		
		IC.printItemList();
		
		System.out.println("...");
		System.out.println("\n");
		
		a.getUserCart().addItem(item3);
		a.getUserCart().addItem(item2);
		
		System.out.println("\n");
		
		a.getUserCart().printCartList();
		
		System.out.println("\n");
		System.out.println("\n");
		
		a.getUserCart().addItem(item2);
		
		System.out.println("\n");
		
		a.getUserCart().printCartList();
		
		System.out.println("\n");
		System.out.println("\n");
		
		System.out.println("***Check out");
		
		System.out.println("\n");

		a.createOrder("Paypal", 432503632, a.getAccountID(), a.getUserCart().cartTotal);
		
		System.out.println("Order Num " + a.getOrderNum() + " created for Account " + a.getAccountID() + "\n");
		
		a.getOrder().printOrder();
		
		System.out.println("\n");
		System.out.println("\n");
		
		a.getUserCart().emptyCart();
		
		a.getUserCart().printCartList();
		
		System.out.println("\n");
		
		System.out.println("***end program");
		
		
		
		
		
		
		/*int userInput = 0;
		
		while (userInput != 4)
		{
			System.out.println("What would you like to do next?");
			System.out.println("press 1 to add an item to your cart");
			System.out.println("press 2 to remove an item from your cart");
			System.out.println("press 3 to veiw the items in your cart");
			System.out.println("press 4 to check out");
			
			userInput = input.nextInt();
			
			if (userInput == 1)
			{
				System.out.println("Which item would you like to add? type the number of the item you want");
				System.out.println("Item 1");
				System.out.println("Item 2");
				System.out.println("Item 3");
				int userInput2 = input.nextInt();
				
				if(userInput2 == 1)
				{
					a.getUserCart().addItem(item1);
					System.out.println("Item 1 added to cart \n");
				}
				else if(userInput2 == 2)
				{
					a.getUserCart().addItem(item2);
					System.out.println("Item 2 added to cart \n");
				}
				else
				{
					a.getUserCart().addItem(item3);
					System.out.println("Item 3 added to cart \n");
				}
			}
			else if (userInput == 2)
			{
				System.out.println("Which item would you like to remove? type the number of the item you want out");
				System.out.println("Item 1");
				System.out.println("Item 2");
				System.out.println("Item 3");
				int userInput2 = input.nextInt();
				
				if(userInput2 == 1)
				{
					a.getUserCart().removeItem(1);
					System.out.println("Item 1 removed from cart \n");
				}
				else if(userInput2 == 2)
				{
					a.getUserCart().removeItem(2);
					System.out.println("Item 2 removed from cart \n");
				}
				else
				{
					a.getUserCart().removeItem(3);
					System.out.println("Item 3 removed from cart \n");
				}
			}
			else if (userInput == 3)
			{
				a.getUserCart().printCartList();
			}
			
		}
		System.out.println("Check out \n");
		System.out.println("Order Num 1 created for Account 1");
		System.out.println("Payment type: Paypal");
		System.out.println("Account Num: 73945");
		System.out.println("Order Date 5/7/2014");
		System.out.println("Order Amount: " + a.getUserCart().getTotal());
		
		if (a.getUserCart().getTotal() > 0)
		{
			System.out.println("shipping: $12.40");
		}
		else
		{
			System.out.println("shipping: $0");
		}
		*/
	}

}
