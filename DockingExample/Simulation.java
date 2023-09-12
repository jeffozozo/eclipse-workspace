
public class Simulation
{

	public static void main(String[] args)
	{
		SpaceStation Station = new SpaceStation();
		SpaceShuttle Shuttle = new SpaceShuttle();
		
		Shuttle.dockWith(Station);

	}

}
