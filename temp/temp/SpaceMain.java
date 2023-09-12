package temp;

public class SpaceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpaceStation spaceStation= new SpaceStation();
		SpaceShuttle Shuttle = new SpaceShuttle();
		
		spaceStation.DockWith(Shuttle,0,0, false);
		System.out.println("\n");
		Shuttle.DockWith(spaceStation, 0, 0,false);
		
	}

}
