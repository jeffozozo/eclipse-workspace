
public class Tank extends Vehicle 
{

	@Override
	public void move(double latIn, double longIn) 
	{
		System.out.println("Tank moving slowly to "+latIn+","+longIn);
	}

	@Override
	public void fire() {
		
		System.out.println("Tank firing 120 mm cannon.");

	}
	
	public String toString()
	{
		return "This is a tank";
	}
	

}
