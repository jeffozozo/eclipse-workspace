import java.util.Date;


public class Ticket 
{
	String event;
	Date date = new Date();
	double price;

	public Ticket(String eventIn, double priceIn)
	{
		event = eventIn;
		price = priceIn;
		
	}
	
	public void setPrice(double priceIn)
	{
		price = priceIn;
	}
	public double getPrice()
	{
		return price;
	}
	
	public void printTicket()
	{
		System.out.println("event: "+ event + " price $"+ price);
	}

}
