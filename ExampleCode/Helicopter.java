
public class Helicopter extends Vehicle 
{

	@Override
	public void move(double latIn, double longIn) 
	{
		System.out.println("Helicopter takes off.");
		System.out.println("Helicopter moves to "+latIn+", "+longIn);
	}

	@Override
	public void fire() 
	{
		System.out.println("Helicopter firing 30mm machine gun.");
		
	}

}
