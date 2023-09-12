
public class Discounter 
{
	double discountRate =  0.75;
	
	
	public void discount(Ticket ticket)
	{
		double tempPrice; 
		
		tempPrice = ticket.getPrice() * discountRate;
		
		ticket.setPrice(tempPrice);
		
	}
	
}
