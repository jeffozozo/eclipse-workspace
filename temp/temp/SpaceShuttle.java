package temp;

public class SpaceShuttle implements Dockable
{
 String Name = "CHallanger" ;
 
 
	
 

	@Override
	public String OpenHatch() {
		System.out.println("Hatch on "+Name+" is opening.");
		return null;
	}

	@Override
	public String DockWith(Dockable SpacestationIn, int a, int b,boolean docked) {
		if (a==0)
		{
			System.out.println(Name+" docked with Space station");
			SpacestationIn.DockWith(this,1,b,false);
			
		}
		if (a==1&&b==1)
		{
			if (docked ==false)
				{
				System.out.println(Name+" confirming with "+ SpacestationIn.getName()+" connection is good ");
				SpacestationIn.DockWith(this,a,b,true);
				}
			
			if (docked ==true )
				{
				System.out.println(Name+" Hand shake with "+SpacestationIn.getName()+" is good ");
				OpenHatch();				
				System.out.println(Name+" docking complete ");				
				SpacestationIn.DockWith(this,2,2,true);				
				}			
		}
		if (a>1)
			{
			if (docked ==true&& b==2 )
				{
				System.out.println(Name+" Hand shake with "+SpacestationIn.getName()+" is good ");
				OpenHatch();				
				System.out.println(Name+" docking complete ");			
				}
			}
		return null;
	}
	@Override
	public String getName() {
		
		return Name;
	}

	
	
}
