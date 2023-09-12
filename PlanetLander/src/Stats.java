
public class Stats
{
	String planetName;
	double landerAltitude;
	double landerSpeed;
	double fuelRemaining;
	double currentGravity;	
	
	Planet thePlanet;
	Settings theSettings;
	
	public Stats(Settings settingsIn, Planet thePlanetIn)
	{
		theSettings = settingsIn;
		thePlanet = thePlanetIn;
		
		currentGravity = thePlanetIn.getYGravity();
		planetName = thePlanetIn.getName();
		fuelRemaining = settingsIn.initFuel;
		landerAltitude = 0.0;
		landerSpeed = 0.0;
	}
	
	
	//assumes settings and planet have been reset first.
	public void reset()
	{
		landerAltitude = 0.0;
		landerSpeed = 0.0;
		fuelRemaining = theSettings.initFuel;
		currentGravity = thePlanet.getYGravity();
		
	}
	
	
	
	
}
