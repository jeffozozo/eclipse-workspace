package lunarLander;

public class lander 
{
	double gravity; // meters per second per second
	double altitude; //meters
	double velocity;
	double fuel_remaining; //units
	
	public lander(double alt_in, double gravity_in, int fuel_in)
	{
		gravity = gravity_in;
		altitude = alt_in;
		velocity = 0;
		fuel_remaining = fuel_in;
		
	}
	
	public boolean next_second(int fuel_in, String planetName )
	{
		double thrust;
		int fuel_used;
		
		velocity += gravity;
		
		thrust = .9 * fuel_in;
		if(thrust > 10)
		{
			fuel_used = 11;
			thrust = 10;
		}
		else
		{
			fuel_used = fuel_in;
		}
		
		fuel_remaining -= fuel_used;
		velocity -= thrust;
		altitude -= velocity;
		
		if(altitude <=0 && velocity <= 2)
		{
			System.out.println("The lander successfully touched down on " + planetName );
			return false;
		}
		
		if(altitude <=0 && velocity > 2)
		{
			System.out.println("The lander CRASHED! Velocity must be less than 2 meters per second.");
			return false;
		}
		
		return true;
		
	}
	
	public void printLocation()
	{
		System.out.println();
		System.out.println("Lander Status:");
		System.out.println("  altitude: "+ altitude);
		System.out.println("  velocity: "+ velocity);
		System.out.println("  fuel remaining: " + fuel_remaining);
		
	}
	
}
