package missileSimulator;


public class missile 
{
	double current_lat;
	double current_long;
	
	double origin_lat;
	double origin_long;
	
	double target_lat;
	double target_long;
	
	double current_altitude;
	double delta_altitude;
	private static final double max_altitude = 45000; //feet 
	
	boolean in_flight;
	boolean armed;
	boolean exploded;
	
	missileFlightTable guidanceSystem;
	
	public missile(double origin_lat_in, double origin_long_in, double target_lat_in, double target_long_in)
	{
		origin_lat = origin_lat_in;
		origin_long = origin_long_in;
		target_lat = target_lat_in;
		target_long = target_long_in;
		
		current_lat = origin_lat;
		current_long = origin_long;
		
		armed = false;
		exploded = false;
		
	}
	
	
	public void launch(String key_code)
	{
		System.out.println("Missile Launched.");
		
		
		in_flight = true;
		current_altitude = 0;
		delta_altitude = 1000;
		current_lat = origin_lat;
		current_long = origin_long;
		guidanceSystem = new missileFlightTable();
	}
	
	public void arm(String key_code)
	{
		armed = true;
	}
	
	public void disarm(String key_code)
	{
		armed = false;
	}
	
	public boolean move()
	{
		if(!in_flight)
			return false;

		double mf = guidanceSystem.getMoveFactor(current_altitude);
		
		current_altitude += delta_altitude;
		
		if(current_altitude >= max_altitude)
			delta_altitude = -1000;
		
		
		if(current_lat < target_lat )
		{
			current_lat += mf;
		}	
		else if(current_lat > target_lat)
		{
			current_lat -= mf;
		}
		
		if(current_long < target_long)
		{
			current_long += mf;
		}
		else if(current_long > target_long)
		{
			current_long -= mf;
		}
		
		if (current_altitude <=0 )
		{
			in_flight = false;
			track();
			
			if(armed)
			{
				exploded = true;
				System.out.println("Missile exploded.");
			}
		}	
		
		
		
		return in_flight;
		
	}
	
	public void track()
	{
		String status;
		
		if(armed) 
			status = "armed";
		else 
			status = "disarmed";

		if(in_flight)
			status += ", in flight";
		else
			status += ", not in flight";
			
		
		
		
		System.out.println("Missile at:");
		System.out.println("lat: " + current_lat);
		System.out.println("long: " + current_long);
		System.out.println("Altitude: " + current_altitude);
		System.out.println("Status: " + status  );
		System.out.println();
	}
	
	
}
