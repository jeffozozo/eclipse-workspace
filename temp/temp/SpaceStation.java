package temp;

public class SpaceStation implements Dockable {
	protected String StationName = "Mere";
	//boolean docked ;
	
	public  String  getName()
	{
		return StationName ;		
	}
	@Override
	public String DockWith(Dockable shuttle,int a, int b,boolean docked) {
		if (b==0)
		{
			System.out.println(StationName+" docked with Shuttle");
			shuttle.DockWith(this,a,1,false);			
		}
		if (a==1&&b==1 )
		{
			if ( docked == false)
			{				
				System.out.println(StationName+" confirming with "+shuttle.getName()+" connection is good ");
			shuttle.DockWith(this,a,b,true);
			}
			if (docked ==true )
			{
				System.out.println(StationName+" Hand shake with "+shuttle.getName()+" is good ");
				OpenHatch();				
				System.out.println(StationName+" Space Station docking complete");
				shuttle.DockWith(this,2,2,true);
			}			
		}

		if (a>1)
		{
			System.out.println(StationName+" Hand shake with "+shuttle.getName()+" is good ");
			OpenHatch();			
			System.out.println(StationName+" Space Station docking complete");
		}
		return null;
	}

	@Override
	public String OpenHatch() {
		System.out.println("Hatch is Opening in "+StationName+ " Space Station. ");
		
		return null;
	}	

}
