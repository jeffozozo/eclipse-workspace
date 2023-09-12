
public class ChassisBuilder extends Machine 
{

	@Override
	public void build(Car carIn) 
	{
		Chassis theChassis = new Chassis();
		
		
		if(Math.round(Math.random()*50) == 1)
		{
			//this is a simulation of the machine goofing up. I know the glue wheels is going to complain. 		
			if(!theChassis.glueWheels())
			{
					System.out.println("Error in building the chassis for: " + carIn);
			}
				
			theChassis.insertAxles();
		}
		else
		{
			theChassis.insertAxles();
			theChassis.glueWheels();
		}
		
		carIn.setChassis(theChassis);

	}

}
