import java.util.*;

public class ShoppingCartMain 
{
	
	public static void main (String[] args) 
	{
		// Set up the account upon beginning the program (anything more was out of scope)
		Account myAccount = new Account();
		
		//Simple greeting
		System.out.println("Welcome " + myAccount.userName + ("!\nSelect from our catalog below: \n"));
		
		// Display the catalog for the customer to see
		ItemCatalog catalog1 = new ItemCatalog();
		catalog1.catalogDisplay();
		
		
		//main item selection process///////////
		Scanner scan1 = new Scanner(System.in);
		String response;
		
		do 
		{
			response = "";
			System.out.println("\n\nEnter the item number of the product that you would like to add to your cart: ");
			System.out.println("To remove an item from your cart, enter 'remove'.");
			System.out.println("(Enter 'q' when you are finished shopping)\n");
			response = scan1.next();
			
			// If item is selected to add to cart
			if (response.equals("1") || response.equals("2") || response.equals("3")) 
			{
				int intResponse = (Integer.parseInt(response))-1;
				myAccount.addToCart(intResponse);
				myAccount.displayMyCart();
			}
			else if (response.equalsIgnoreCase("remove"))	//if item needs to be removed from the cart
			{
				System.out.println("Enter the item number you would like to remove from your cart: ");
				response = scan1.next();
				int intResponse = (Integer.parseInt(response))-1;
				myAccount.removeFromCart(intResponse);
				myAccount.displayMyCart();
			}
			else 
			{
				System.out.println("I'm sorry, I didn't understand that response.");
			}
			
		}while(!response.equalsIgnoreCase("q"));
		
		response = "";
		System.out.println("\n\nWould you like to proceed to checkout(Yes/No)?");
		response = scan1.next();
		
		if (response.equalsIgnoreCase("yes"))
		{
			myAccount.handleOrder();
		}
		else 
		{
			System.out.println("You have chosen to exit without checkout.  Goodbye.");
		}
				
	}	
}