
public class Settings
{
	//a.	Initial Velocity of Lander
	public double xInit, yInit;
	
	//b.	Crashing speed in m/sec
	public double crashingSpeed;
	
	//c.	Initial Fuel Amount
	public double initFuel;
	
	//d.	Optional: Amount of fuel used while pressing the thruster. It might be easier to fiddle with here, than trying to figure out how much to use by the tweak-n-try method…)
	public double fuelPerThruster;
	
	//e.	Width of the landing spot
	public int landingPadWidth;
	
	//default settings
	public Settings()
	{
		xInit = .1;
		yInit = .1;
		
		crashingSpeed = 4;
		initFuel = 500;
		
		fuelPerThruster = .1;
		
		landingPadWidth = 50;
	}
	
}
