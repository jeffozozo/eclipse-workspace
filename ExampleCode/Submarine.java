
public class Submarine extends Vehicle 
{

	@Override
	public void move(double latIn, double longIn) 
	{
		latitude = latIn;
		longitude = longIn;
		System.out.println("Submarine diving");
		System.out.println("Submarine moving to " + latIn +", " +longIn);
		System.out.println("Submarine surfacing.");
	}

	@Override
	public void fire() 
	{
		System.out.println("Submarine firing ballistic missile.");

	}
	
	
	

}
