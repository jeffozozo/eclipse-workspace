import java.text.DecimalFormat;


public class car 
{
	String name;
	int number;
	static final double milesPerSecond = 0.0003;
	
	double maxSpeed; // miles per second
	double acceleration; // miles per second per second
	double corneringFactor;	// a percentage 
	double currentSpeed; //miles per second
	double totalTime; // seconds
	
	public car(String name_in, int number_in, double d, double e, double f )
	{
		name = name_in;
		number = number_in;
		maxSpeed = d * car.milesPerSecond;
		acceleration = e * car.milesPerSecond;
		corneringFactor = f;
		currentSpeed = 0;
		totalTime = 0;
	}

	//returns the number of seconds it took this car to traverse the track segment
	public double drive(trackSegment ts)
	{
		double current_acc = acceleration;				
	
		if(ts.getStyle() == trackStyle.curve)
		{
			
			if(currentSpeed > maxSpeed * corneringFactor)
				currentSpeed = maxSpeed * corneringFactor;
			
		}
			
		//now find the time it took.
		// distance = 1/2a*t^2 + vi*t
		// t = sqrt(2ad + v^2 - v) / a
		
		double temp = Math.abs(2 * current_acc * ts.getLength() + (currentSpeed*currentSpeed) - currentSpeed);
		double seconds = Math.sqrt( temp ) / current_acc;
		totalTime = totalTime + seconds;
		
		//now find end velocedi -- if we curved, we just stay at current speed. if straight, we accelerated.
		if(ts.getStyle() == trackStyle.straight)
		{
			currentSpeed = currentSpeed + current_acc*seconds;
		}	
		
		//System.out.println("debug: " +this.name+": speed:"+currentSpeed*3400+" track style:"+ts.getStyle()+" distance: "+ts.getLength()+ " time: "+seconds);
		
		return seconds;
	}

	public void printTotalTime()
	{
		DecimalFormat df = new DecimalFormat("#.##");		
		System.out.println(name + ": "+ "\ttime: "+ df.format(totalTime) + " seconds." );
	}
	
}
