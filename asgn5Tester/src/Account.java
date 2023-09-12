

public class Account {
	
	String userName; 
	String password;
	Cart userCart;
	int accountID;
	
	Order userOrder;
	int orderNum; 
	Order [] orderList;
	
	public Account(String userNameIn, String passwordIn, int accountIdIn)
	{
		userName = userNameIn;
		password = passwordIn;
		userCart = new Cart();
		accountID = accountIdIn;
		orderList = new Order[10];
	}
	
	public void createOrder(String paymentMethodIn, int cardNumIn, int AccountIdIn, double orderTotalIn)
	{
		userOrder = new Order(paymentMethodIn, cardNumIn, AccountIdIn, orderTotalIn);
		orderList[orderNum] = userOrder; // keeps track of orders
		orderNum++;
	}
	
	
	public Order getOrder()
	{
		return userOrder;
	}
	
	public int getOrderNum()
	{
		return orderNum;
	}
	
	public int getAccountID()
	{
		return accountID;
	}
	
	public Cart getUserCart() 
	{
		return userCart;
	}

	public String getUserName() 
	{
		return userName;
	}

	public String getPassword() 
	{
		return password;
	}
	
	

}
