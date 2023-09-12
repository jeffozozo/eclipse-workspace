import java.util.*;

public class Account 
{
	protected String userName = "";
	private String password = "";
	protected int accountID = 1234;
	protected Cart myCart = new Cart();
	//protected Order myOrder = new Order();
	
	Scanner scan = new Scanner(System.in);
	
	public Account()
	{	
		System.out.println("Please enter your username: ");
		this.userName = scan.next();
			
		System.out.println("Please enter your password: ");
		this.password = scan.next();
		
	}
	
	public void addToCart(int i)
	{
		myCart.addItem(i);
	}
	
	public void removeFromCart(int i)
	{
		myCart.removeItem(i);
	}
	
	public void displayMyCart()
	{
		myCart.cartDisplay();
	}
	
	public void handleOrder()
	{
		myCart.createOrder();
	}
}