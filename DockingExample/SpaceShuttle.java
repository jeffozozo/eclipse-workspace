
public class SpaceShuttle implements Dockable
{
	Dockable connectedTo;
	String name = "Shuttle Challenger";
	
	@Override
	public void dockWith(Dockable d)
	{
		System.out.println(name + " docking procedure...");
		if(connectedTo != null) // this makes sure that we don't recursively call dockedWith forever.
		{
			System.out.println(name + " Connected Check Complete. Currently docked with "+ d.getName());
			return;
		}
		
		connectedTo = d;
		d.dockWith(this); // this makes it so BOTH things are connected without having to control it from the main function

		openHatch();

		
	}

	@Override
	public void openHatch()
	{
		System.out.println(name + "Attempting to open hatch...");
		if(connectedTo != null)
		{
			System.out.println(name+" hatch is open.");
		}
		else
		{
			System.out.println(name+" is not currently docked. Hatch remains closed.");
		}
	}
	
	@Override
	public String getName()
	{
		return name;
	}

}
