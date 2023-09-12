
public class Chassis extends Part
{
	private boolean wheelsGlued;
	private boolean axlesInserted;

	
	public Chassis()
	{
		name="default chasis";
		serialNum = 0;		
	}
	
	public boolean glueWheels()
	{
		if(!axlesInserted)
		{
			System.out.println("Attempted to glue wheels without axles!");
			return false;
		}
		
		wheelsGlued = true;		
		return true;
		
	}
	
	public void insertAxles()
	{
		axlesInserted = true;
	}
	
	
	
	public boolean rolls()
	{
		//if the car is put together correctly, it rolls. otherwise...
		if(axlesInserted && wheelsGlued )
			return true;
		
		return false;
	}
	
}
